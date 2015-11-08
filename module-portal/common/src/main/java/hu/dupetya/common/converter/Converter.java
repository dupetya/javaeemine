package hu.dupetya.common.converter;

public interface Converter<S, T> {
  T convert(S source) throws ConversionException;
}
