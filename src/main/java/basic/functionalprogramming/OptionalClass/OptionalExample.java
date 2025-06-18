package basic.functionalprogramming.OptionalClass;

/**
 * Key Methods
 * Optional.of(value): Creates an Optional containing a non-null value.
 * Optional.ofNullable(value): Creates an Optional that may contain a null value.
 * Optional.empty(): Creates an empty Optional.
 * isPresent(): Returns true if a value is present.
 * orElse(defaultValue): Returns the value if present, otherwise returns defaultValue.
 * map(function): Transforms the value if present, returning a new Optional.
 * ifPresent(consumer): Executes an action if a value is present.
 */

import java.util.Optional;

public class OptionalExample {

    public static void main(String[] args) {
        Optional<String> name = Optional.of("Alice");
        Optional<String> empty = Optional.empty();

        System.out.println(name.orElse("No Value"));
        System.out.println(name.orElseGet(() -> "Default Value"));
        System.out.println(empty.orElseGet(() -> "Default Value for empty optional"));
    }
}

