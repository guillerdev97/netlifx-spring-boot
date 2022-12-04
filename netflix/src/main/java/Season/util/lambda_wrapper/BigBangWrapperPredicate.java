package Season.util.lambda_wrapper;

import java.util.function.Predicate;

import Season.exception.BigBangException;
import Season.exception.BigBangRuntimeException;

@FunctionalInterface
public interface BigBangWrapperPredicate<T, E extends BigBangException> {

	boolean test(T item) throws E;

	static <T, E extends BigBangException> Predicate<T> wrap(final BigBangWrapperPredicate<T, E> wrapper) {
		return item -> {
			try {
				return wrapper.test(item);
			} catch (final BigBangException exception) {
				throw new BigBangRuntimeException(exception);
			}
		};
	}

}
