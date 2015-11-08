package hu.dupetya.common.validator;

public interface Validator<T> {
  void validate(T object) throws ViolationException;
}
