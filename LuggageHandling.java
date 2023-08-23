
import java.util.*;
import java.io.*;
import java.lang.*;

class Container {
    float length;
    float bredth;
    float height;
    float volume;
    int count = 0;
    float startVolume;

    String[] luggagetype = new String[100];
    float[] luggagevolume = new float[100];

    public void setVolume() {
        volume = length * bredth * height;
        startVolume = volume;
    }

    public float getVolume() {
        return volume;
    }

    public void calculateActualVolume(float vol, String name) {
        count++;
        luggagetype[count] = name;
        luggagevolume[count] = vol;
        volume = volume - vol;
    }

    public void allDetails() {
        // LuggageType newObject=new LuggageType();
        LuggageHandling newObject = new LuggageHandling();
        System.out.println("\nVolume of main Container is : " + startVolume);
        System.out.println("Number of luggage in Container is : " + count);
        System.out.println("volume unutilised after putting in all the luggage in Container is : " + getVolume());
        System.out.println("\nList of luggage is : ");
        for (int i = 1; i <= count; i++) {
            System.out.print(luggagetype[i] + " ---> " + luggagevolume[i] + "\n");
        }
        System.out.println("\n");
        int j = 1;
        for (int i = 1; i <= count; i++) {
            if (luggagetype[i] == "Cube") {
                System.out.println("Dimension of Cube is : " + newObject.p[j++]);
            } else if (luggagetype[i] == "Cuboid") {
                System.out.print("Dimension of Cuboid is : " + newObject.p[j++] + " ," + newObject.p[j++]);
                System.out.print(" ," + newObject.p[j++] + "\n");
            } else if (luggagetype[i] == "Sphere") {
                System.out.println("Radius of Sphere is : " + newObject.p[j++]);
            } else {
                System.out.println("Dimension of Random luggage is : " + newObject.p[j++]);

            }
        }
    }

}

class LuggageType {

    public class cube {
        float length;
        float vol1;

        public float getVolume() {
            vol1 = length * length * length;
            return vol1;
        }
    }

    public class cuboid {
        public float breadth;
        float length;
        float bredth;
        float height;
        float vol2;

        public float getVolume() {
            vol2 = length * bredth * height;
            return vol2;
        }

    }

    public class sphere {
        float radius;
        float vol3;

        public float getVolume() {
            vol3 = (float) (1.33 * Math.PI * Math.pow(radius, 3));
            return vol3;
        }

    }

}

public class LuggageHandling {
    public static float[] p = new float[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Container mainContainer = new Container();

        System.out.println("Enter the length of the Container : ");
        mainContainer.length = sc.nextFloat();
        System.out.println("Enter the breadth of the Container : ");
        mainContainer.bredth = sc.nextFloat();
        System.out.println("Enter the height of the Container : ");
        mainContainer.height = sc.nextFloat();
        mainContainer.setVolume();
        System.out.println("The volume of main container is : " + mainContainer.getVolume());

        System.out.println("\nYou have to enter any one number for choosing the luggage type ");
        System.out.println("If luggage type is Cube then enter 1  ");
        System.out.println("If luggage type is Cuboid then enter 2 ");
        System.out.println("If luggage type is Sphere then enter 3 ");
        System.out.println("If luggage type is Random then enter 4 ");
        System.out.println("If you want to exit then enter 5\n");

        boolean k = true;
        int i = 1, r = 1;

        while (k) {
            if(mainContainer.getVolume()==0)
            {
                break;
            }
            System.out.println("Round number: " + r++);
            System.out.print("\nPlease enter your Choice: ");
            int b = sc.nextInt();

            switch (b) {
                case 1 -> {
                    LuggageType.cube type1 = new LuggageType().new cube();
                    System.out.println("Enter the length of the cube: ");
                    type1.length = sc.nextFloat();
                    if (mainContainer.getVolume() >= type1.getVolume()) {
                        p[i] = type1.length;
                        i++;
                        System.out.println("The volume of the cube is : " + type1.getVolume());
                        mainContainer.calculateActualVolume(type1.getVolume(), "Cube");
                        System.out.println("Now the volume of the main Container is : " + mainContainer.getVolume());
                        break;
                    } else
                        System.out.println("Volume of main Container is less than the volume of luggage");
                    break;

                }

                case 2 -> {
                    LuggageType.cuboid type2 = new LuggageType().new cuboid();

                    System.out.println("Enter the length of the Container : ");
                    type2.length = sc.nextFloat();

                    System.out.println("Enter the breadth of the Container : ");
                    type2.bredth = sc.nextFloat();

                    System.out.println("Enter the height of the Container : ");
                    type2.height = sc.nextFloat();

                    if (mainContainer.getVolume() >= type2.getVolume()) {
                        p[i] = type2.length;
                        i++;
                        p[i] = type2.bredth;
                        i++;
                        p[i] = type2.height;
                        i++;
                        System.out.println("The volume of the cube is : " + type2.getVolume());
                        mainContainer.calculateActualVolume(type2.getVolume(), "Cuboid");
                        System.out.println("the volume of main container is : " + mainContainer.getVolume());
                        break;
                    } else
                        System.out.println("Volume of main Container is less than the volume of luggage");
                    break;
                }

                case 3 -> {
                    LuggageType.sphere type3 = new LuggageType().new sphere();
                    System.out.println("Enter the radius of the Container : ");
                    type3.radius = sc.nextFloat();

                    if (mainContainer.getVolume() >= type3.getVolume()) {
                        p[i] = type3.radius;
                        i++;
                        System.out.println("The volume of the sphere is : " + type3.getVolume());
                        mainContainer.calculateActualVolume(type3.getVolume(), "Sphere");
                        System.out.println("the volume of main container is : " + mainContainer.getVolume());
                        break;
                    } else
                        System.out.println("Volume of main Container is less than the volume of luggage");
                    break;
                }

                case 4 -> {
                    System.out.println("Enter the Volume of the Container : ");
                    float vol4 = sc.nextFloat();
                    if (mainContainer.getVolume() >= vol4) {
                        p[i] = vol4;
                        i++;
                        mainContainer.calculateActualVolume(vol4, "Random");
                        System.out.println("the volume of main container is : " + mainContainer.getVolume());
                        break;
                    } else
                        System.out.println("Volume of main Container is less than the volume of luggage");
                    break;
                }

                case 5 -> {
                    break;

                }

                default -> {
                    System.out.println("PLEASE ENTER CORRECT NUMBER!");
                }

            }

            if (b == 5) {
                break;
            }
            System.out.println("\n");
        }

        mainContainer.allDetails();

    }
}
