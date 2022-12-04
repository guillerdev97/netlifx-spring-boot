package Season.util.lambda_wrapper;

import java.util.function.Consumer;

import Season.exception.BigBangException;
import Season.exception.BigBangRuntimeException;

@FunctionalInterface
public interface BigBangWrapperConsumer<T, E extends BigBangException> {

	void accept(T item) throws E;

	static <T, E extends BigBangException> Consumer<T> wrap(final BigBangWrapperConsumer<T, E> wrapper) {
		return item -> {
			try {
				wrapper.accept(item);
			} catch (final BigBangException exception) {
				throw new BigBangRuntimeException(exception);
			}
		};
	}

}
