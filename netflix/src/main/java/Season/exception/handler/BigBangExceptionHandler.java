package Season.exception.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import Season.controller.rest.model.BigBangResponse;
import Season.exception.BigBangException;
import Season.exception.BigBangRuntimeException;
import Season.exception.error.ErrorMessageService;
import Season.exception.error.ErrorRest;
import Season.util.constant.ExceptionConstantsUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@ControllerAdvice
@SuppressWarnings({ "rawtypes", "unchecked" })
@Log4j2
@RequiredArgsConstructor
public class BigBangExceptionHandler {

	private final ErrorMessageService errorMessageService;

	@ExceptionHandler({ Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BigBangResponse unhandledErrors(final HttpServletRequest req, final Exception ex) {
		logException(ex);
		return new BigBangResponse(ExceptionConstantsUtils.ERROR,
				Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()), ex.getMessage());
	}

	@ExceptionHandler({ BigBangException.class })
	@ResponseBody
	public BigBangResponse handleException(final HttpServletRequest request, final HttpServletResponse response,
			final BigBangException ex) {
		logException(ex);
		response.setStatus(ex.getCode());

		final ErrorRest[] errorRestArray = ex.getErrorDtoCollection().stream().map(
				errorDto -> new ErrorRest(errorDto.getCode(), errorMessageService.getCodes().get(errorDto.getCode())))
				.toArray(ErrorRest[]::new);

		return new BigBangResponse(ExceptionConstantsUtils.ERROR, Integer.toString(ex.getCode()), ex.getMessage(),
				errorRestArray);
	}

	@ExceptionHandler({ BigBangRuntimeException.class })
	@ResponseBody
	public BigBangResponse handleException(final HttpServletRequest request, final HttpServletResponse response,
			final BigBangRuntimeException ex) {
		return handleException(request, response, ex.getBigBangException());
	}

	private void logException(final Exception exception) {
		log.error(ExceptionUtils.getStackTrace(exception));
	}

}
