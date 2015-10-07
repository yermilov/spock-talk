class PasswordGenerator {

    def alphabet = ('a'..'z').join()
    Random random = new Random()

    String generate(int length) {
        (1..length).collect({ nextSymbol() }).join()
    }

    char nextSymbol() {
        alphabet[random.nextInt(alphabet.length())]
    }
}
