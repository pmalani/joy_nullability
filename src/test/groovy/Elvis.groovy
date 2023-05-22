
String say1(String input) {
    String name = input == null ? 'Doh!' : input
    return "Hello, ${name}"
}

String say2(String input) {
    String name = input ?: 'Doh!'
    return "Hello, ${name}"
}

//println say1(null)
//println say1("World")

//println say2(null)
//println say2("World")
