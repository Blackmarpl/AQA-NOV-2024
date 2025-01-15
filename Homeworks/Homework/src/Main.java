public class Main {
    public static void main(String[] args) {



        class ClassA {
            public void baseMethod() {
                System.out.println("Method from ClassA");
            }
        }


        class ClassB extends ClassA {
            @Override
            public void baseMethod() {
                System.out.println("Overridden method in ClassB");
            }
        }


        class ClassC extends ClassB {

        }


        class ClassD extends ClassC {
            @Override
            public void baseMethod() {
                System.out.println("Overridden method in ClassD");
            }


            public void overloadedMethod(int a) {
                System.out.println("Method with one parameter: " + a);
            }

            public void overloadedMethod(int a, int b) {
                System.out.println("Method with two parameters: " + a + ", " + b);
            }

            public void overloadedMethod(int a, int b, int c) {
                System.out.println("Method with three parameters: " + a + ", " + b + ", " + c);
            }
        }

    }
}