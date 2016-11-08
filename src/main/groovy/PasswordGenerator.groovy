class PasswordGenerator {

    static PasswordGenerator build() {
        new PasswordGenerator(alphabet: ('a'..'z').join(), random: new Random())
    }

    String alphabet
    Random random

    String generate(int length) {
        (1..length).collect({ nextSymbol() }).join()
    }

    String generate() {
        generate(8 + random.nextInt(10))
    }

    char nextSymbol() {
        alphabet[random.nextInt(alphabet.length())]
    }
}
