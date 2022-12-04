package Season.exception;

import java.util.Collection;

import org.springframework.http.HttpStatus;

import Season.exception.error.ErrorDto;

import lombok.Getter;

@Getter
public class BigBangBadRequestException extends BigBangException {

	private static final long serialVersionUID = 105837498733124083L;

	public BigBangBadRequestException(final Collection<ErrorDto> errorDtoCollection) {
		super(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), errorDtoCollection);
	}

	public BigBangBadRequestException(final ErrorDto errorDto) {
		super(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name(), errorDto);
	}

}
