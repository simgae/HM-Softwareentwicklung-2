public record ComeAndGo() {
    public ComeAndGo {
        System.out.println("Oh, hi, it's you!");
    }

    void talk(String message) {
        System.out.println(message + " - that's nice :)");
    }

    public void close() {
        System.out.println("Farewell!");
    }
}

class ComeAndGoMain {
    public static void main(String... args) {
        ComeAndGo comeAndGo = new ComeAndGo();
        comeAndGo.talk("hello!");
        comeAndGo.close();
    }
}
