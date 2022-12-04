package Season.util.lambda_wrapper;

import java.util.function.Function;

import Season.exception.BigBangException;
import Season.exception.BigBangRuntimeException;

@FunctionalInterface
public interface BigBangWrapperFunction<T, R, E extends BigBangException> {

	R apply(T item) throws E;

	static <T, R, E extends BigBangException> Function<T, R> wrap(final BigBangWrapperFunction<T, R, E> wrapper) {
		return item -> {
			try {
				return wrapper.apply(item);
			} catch (final BigBangException exception) {
				throw new BigBangRuntimeException(exception);
			}
		};
	}

}
