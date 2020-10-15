import java.util.Scanner;
public class checkers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] b = new String[64];
        String[] b1 = new String[64];
        int i = 0;
        int j = 0;
        piece one = new piece('A', 2, "r");
        piece two = new piece('A', 4, "r");
        piece three = new piece('A', 6, "r");
        piece four = new piece('A', 8, "r");
        piece five = new piece('B', 1, "r");
        piece six = new piece('B', 3, "r");
        piece seven = new piece('B', 5, "r");
        piece eight = new piece('B', 7, "r");
        piece nine = new piece('C', 2, "r");
        piece ten = new piece('C', 4, "R");
        piece eleven = new piece('C', 6, "R");
        piece twelve = new piece('C', 8, "r");
        piece one1 = new piece('H', 1, "b");
        piece two1 = new piece('H', 3, "b");
        piece three1 = new piece('H', 5, "b");
        piece four1 = new piece('H', 7, "b");
        piece five1 = new piece('G', 2, "b");
        piece six1 = new piece('G', 4, "b");
        piece seven1 = new piece('G', 6, "b");
        piece eight1 = new piece('G', 8, "b");
        piece nine1 = new piece('F', 1, "b");
        piece ten1 = new piece('F', 3, "b");
        piece eleven1 = new piece('F', 5, "b");
        piece twelve1 = new piece('F', 7, "b");
        while (i < 64) {
            char row = 'A';
            if (i < 8) {
                row = 'A';
            } else if (i < 16) {
                row = 'B';
            } else if (i < 24) {
                row = 'C';
            } else if (i < 32) {
                row = 'D';
            } else if (i < 40) {
                row = 'E';
            } else if (i < 48) {
                row = 'F';
            } else if (i < 56) {
                row = 'G';
            } else if (i < 64) {
                row = 'H';
            }
            j = i % 8;
            String w = Integer.toString(j + 1);
            b[i] = row + w;
            b1[i] = row + w;
            b[one.getPosition()] = one.displaypiece();
            b[two.getPosition()] = two.displaypiece();
            b[three.getPosition()] = three.displaypiece();
            b[four.getPosition()] = four.displaypiece();
            b[five.getPosition()] = five.displaypiece();
            b[six.getPosition()] = six.displaypiece();
            b[seven.getPosition()] = seven.displaypiece();
            b[eight.getPosition()] = eight.displaypiece();
            b[nine.getPosition()] = nine.displaypiece();
            b[ten.getPosition()] = ten.displaypiece();
            b[eleven.getPosition()] = eleven.displaypiece();
            b[twelve.getPosition()] = twelve.displaypiece();
            b[one1.getPosition()] = one1.displaypiece();
            b[two1.getPosition()] = two1.displaypiece();
            b[three1.getPosition()] = three1.displaypiece();
            b[four1.getPosition()] = four1.displaypiece();
            b[five1.getPosition()] = five1.displaypiece();
            b[six1.getPosition()] = six1.displaypiece();
            b[seven1.getPosition()] = seven1.displaypiece();
            b[eight1.getPosition()] = eight1.displaypiece();
            b[nine1.getPosition()] = nine1.displaypiece();
            b[ten1.getPosition()] = ten1.displaypiece();
            b[eleven1.getPosition()] = eleven1.displaypiece();
            b[twelve1.getPosition()] = twelve1.displaypiece();
            System.out.print(b[i] + " | ");
            if (j == 7) {
                System.out.println("");
                System.out.println("--------------------------------------");
            }
            i++;
        }
        int i1 = 1;
        while (i1 == 1) {
            System.out.println("Which checker do you want to move. \n Row: \n Number");
            char y = sc.next().charAt(0);
            int a = sc.nextInt();
            int position = 0;
            if (y == 'A') {
                position -= 1;
            }
            if (y == 'B') {
                position += 7;
            }
            if (y == 'C') {
                position += 15;
            }
            if (y == 'D') {
                position += 23;
            }
            if (y == 'E') {
                position += 31;
            }
            if (y == 'F') {
                position += 39;
            }
            if (y == 'G') {
                position += 47;
            }
            if (y == 'H') {
                position += 55;
            }
            position += a;
            int e = 0;
            int f = 0;
            int e1 = 0;
            int f1 = 0;
            
            int r = 0;
            e = position + 7;
            f = position + 9;
            e1 = position - 7;
            f1 = position - 9; 
            String g = b[e];
            String h = b[f];
            System.out.println("Choose one");
            if(b[position] == "r") {
            		System.out.println("1)" + b[e]);
            		System.out.println("2)" + b[f]);
            }
            if(b[position] == "b") {
        		System.out.println("1)" + b[e1]);
        		System.out.println("2)" + b[f1]);
            }
            if(b[position] == "R") {
        		System.out.println("1)" + b[e]);
        		System.out.println("2)" + b[f]);
        		System.out.println("3)" + b[e1]);
        		System.out.println("4)" + b[f1]);
            }
            if(b[position] == "B") {
        		System.out.println("1)" + b[e]);
        		System.out.println("2)" + b[f]);
        		System.out.println("3)" + b[e1]);
        		System.out.println("4)" + b[f1]);
            }
            int c = sc.nextInt();
            if (c == 1) {
                b[e] = b[position];
            }
            if (c == 2) {
                b[f] = b[position];
            }
            b[position] = b1[position];
            b[r] = b1[r];
            if (one.getY() == y) {
                if (one.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        one.setX(khajoor);
                        one.setY(b[1].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    one.setX(khajoor);
                    one.setY(b1[f].charAt(0));
                }
            } else if (two.getY() == y) {
                if (two.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        two.setX(khajoor);
                        two.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    one.setX(khajoor);
                    one.setY(b1[f].charAt(0));
                }
            } else if (three.getY() == y) {
                if (three.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[f].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        three.setX(khajoor);
                        three.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    three.setX(khajoor);
                    three.setY(b1[f].charAt(0));
                }
            } else if (four.getY() == y) {
                if (four.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        four.setX(khajoor);
                        four.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    four.setX(khajoor);
                    four.setY(b1[f].charAt(0));
                }
            } else if (five.getY() == y) {
                if (five.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        five.setX(khajoor);
                        five.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    five.setX(khajoor);
                    five.setY(b1[f].charAt(0));
                }
            } else if (six.getY() == y) {
                if (six.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        six.setX(khajoor);
                        six.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    six.setX(khajoor);
                    six.setY(b1[f].charAt(0));
                }
            } else if (seven.getY() == y) {
                if (seven.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        seven.setX(khajoor);
                        seven.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    seven.setX(khajoor);
                    seven.setY(b1[f].charAt(0));
                }
            } else if (eight.getY() == y) {
                if (eight.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        eight.setX(khajoor);
                        eight.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    eight.setX(khajoor);
                    eight.setY(b1[f].charAt(0));
                }
            } else if (nine.getY() == y) {
                if (nine.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        nine.setX(khajoor);
                        nine.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    nine.setX(khajoor);
                    nine.setY(b1[f].charAt(0));
                }
                System.out.println(nine.getX());
                System.out.println(nine.getY());
            } else if (ten.getY() == y) {
                if (ten.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        ten.setX(khajoor);
                        ten.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    ten.setX(khajoor);
                    ten.setY(b1[f].charAt(0));
                }
            } else if (eleven.getY() == y) {
                if (eleven.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        eleven.setX(khajoor);
                        eleven.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    eleven.setX(khajoor);
                    eleven.setY(b1[f].charAt(0));
                }
            } else if (twelve.getY() == y) {
                if (twelve.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        twelve.setX(khajoor);
                        twelve.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    twelve.setX(khajoor);
                    twelve.setY(b1[f].charAt(0));
                }
            }
            if (one1.getY() == y) {
                if (one1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        one1.setX(khajoor);
                        one1.setY(b[1].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    one1.setX(khajoor);
                    one1.setY(b1[f].charAt(0));
                }
            } else if (two1.getY() == y) {
                if (two1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        two1.setX(khajoor);
                        two1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    one.setX(khajoor);
                    one.setY(b1[f].charAt(0));
                }
            } else if (three1.getY() == y) {
                if (three1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[f].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        three1.setX(khajoor);
                        three1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    three1.setX(khajoor);
                    three1.setY(b1[f].charAt(0));
                }
            } else if (four1.getY() == y) {
                if (four1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        four1.setX(khajoor);
                        four1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    four1.setX(khajoor);
                    four1.setY(b1[f].charAt(0));
                }
            } else if (five1.getY() == y) {
                if (five1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        five1.setX(khajoor);
                        five1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    five1.setX(khajoor);
                    five1.setY(b1[f].charAt(0));
                }
            } else if (six1.getY() == y) {
                if (six1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        six1.setX(khajoor);
                        six1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    six1.setX(khajoor);
                    six1.setY(b1[f].charAt(0));
                }
            } else if (seven1.getY() == y) {
                if (seven1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        seven1.setX(khajoor);
                        seven1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    seven1.setX(khajoor);
                    seven1.setY(b1[f].charAt(0));
                }
            } else if (eight1.getY() == y) {
                if (eight1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        eight1.setX(khajoor);
                        eight1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    eight1.setX(khajoor);
                    eight1.setY(b1[f].charAt(0));
                }
            } else if (nine1.getY() == y) {
                if (nine1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        nine1.setX(khajoor);
                        nine1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    nine1.setX(khajoor);
                    nine1.setY(b1[f].charAt(0));
                }
                System.out.println(nine1.getX());
                System.out.println(nine1.getY());
            } else if (ten1.getY() == y) {
                if (ten1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        ten1.setX(khajoor);
                        ten1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    ten1.setX(khajoor);
                    ten1.setY(b1[f].charAt(0));
                }
            } else if (eleven1.getY() == y) {
                if (eleven1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        eleven1.setX(khajoor);
                        eleven1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    eleven1.setX(khajoor);
                    eleven1.setY(b1[f].charAt(0));
                }
            } else if (twelve1.getY() == y) {
                if (twelve1.getX() == a) {
                    if (c == 1) {
                        char dhakkan = b1[e].charAt(1);
                        int khajoor = Character.getNumericValue(dhakkan);
                        twelve1.setX(khajoor);
                        twelve1.setY(b1[e].charAt(0));
                    }
                }
                if (c == 2) {
                    char dhakkan = b1[f].charAt(1);
                    int khajoor = Character.getNumericValue(dhakkan);
                    twelve1.setX(khajoor);
                    twelve1.setY(b1[f].charAt(0));
                }
            }
            int k = 0;
            while (k < 64) {
                System.out.print(b[k] + " | ");
                int l = k % 8;
                if (l == 7) {
                    System.out.println("");
                    System.out.println("--------------------------------------");
                }
                k++;
            }
        }
    }
}