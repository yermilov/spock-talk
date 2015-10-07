class PasswordGenerator {

    def alphabet = ('a'..'z').join()
    Random random = new Random()

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
