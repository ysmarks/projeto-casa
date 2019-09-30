package br.com.internet.casa;

import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest {

	public static void main(String[] args) {
		
		Stream<String> stream = Stream.of("a", "b","c","d");
		Optional<String> resultado = stream.findAny();
		System.out.println(resultado.get());
	}
}
