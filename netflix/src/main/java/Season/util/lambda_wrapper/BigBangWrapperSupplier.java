package Season.util.lambda_wrapper;

import java.util.function.Supplier;

import Season.exception.BigBangException;
import Season.exception.BigBangRuntimeException;

@FunctionalInterface
public interface BigBangWrapperSupplier<T, E extends BigBangException> {

	T get() throws E;

	static <T, E extends BigBangException> Supplier<T> wrap(final BigBangWrapperSupplier<T, E> wrapper) {
		return () -> {
			try {
				return wrapper.get();
			} catch (final BigBangException exception) {
				throw new BigBangRuntimeException(exception);
			}
		};
	}

}
