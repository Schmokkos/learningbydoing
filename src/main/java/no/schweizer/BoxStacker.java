package no.schweizer;

import no.schweizer.controller.InputController;

class BoxStacker{

    private InputController ic = new InputController();

    BoxStacker() {
        System.out.println("Welcome to the Box Stacker 1.0");
        System.out.println("*************************");

        int[] boxes;

        do {
            boxes = stackInput();
        }
        while (!checkInput(boxes));

    }

    private int[] stackInput(){
        String boxinput = ic.simpleInput("Enter the number of stacks, followed by the size of the boxes. (example: 3 34312332) :", "Invalid input. Please stick to the defined patteren and numbers only(x xxxxxx)", "^[0-9]+ [0-9]+$");
        String boxstring = boxinput.substring(boxinput.indexOf(" ")+1);
        int[] boxes = new int[boxstring.length()+1];
        boxes[0] = Integer.parseInt(boxinput.substring(0,boxinput.indexOf(" ")));
        for (int i = 0; i < boxstring.length(); i++){
            boxes[i+1] = Integer.parseInt(String.valueOf(boxstring.charAt(i)));
        }
        return boxes;
    }

    private boolean checkInput(int[] boxes){
        if (boxes[0] >= boxes.length){
            System.out.println("You need at least as many boxes are there are piles. Try reducing the number of piles or adding more boxes.");
            return false;
        }
        int totalsize = 0;
        for (int a:boxes
             ) {
            totalsize += a;
        }
        totalsize -= boxes[0];
        if (totalsize % boxes[0] != 0) {
            System.out.println("Those box-sizes are not stackable. Try removing or reducing the size of a box by " + totalsize % boxes[0] + ", or adding " + (boxes[0] - (totalsize % boxes[0])) + ".");
            return false;
        }
        return true;
    }
}
