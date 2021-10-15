package edu.asu.cidse.se.creatingclasses;

public class ClassPractice {
    public static void main(String[] args) {
        String nationallity;

        //we are instantiating to create a peace of object in memory
        //by doing a "new"
        Microphone mic = new Microphone("Blue Yeti","Blue",12345);

        //the dot operator allows to get access to the attributes
        //the microphone class.
//        mic.color = "Blue";
//        mic.name = "Blue Yeti";
//         mic.model = 133543;
        // ejsy this does it gives you the memory address of the object.
//        System.out.println(mic);
        // you can easily get accessed to this attribute because there was no private in front of the
        //attribute.
//        System.out.println(mic.color);
        mic.setModel(87);
        mic.setName("New Blue Yeti");
        mic.setColor("Red blue");
        System.out.println("New mic:\n");
        System.out.println(mic.getModel());
        System.out.println(mic.getName());
        System.out.println(mic.getColor());

        //so we are going to call the methods inside of out microphone
        mic.turnOn();
        mic.setVolume();
        mic.turnOff();

        System.out.println(mic.showDescription());

        //thats the beauty of having object oriented becuase you
        //are able to create various objects from one class such as different
        //mics

        //Example.
        //this gives you another object micorphone
        Microphone otherMic = new Microphone("GHMic","Red",4321);
        //this prints out the object with another set of memory.
//        System.out.println(otherMic);
//        otherMic.name = "otherMic";
//        otherMic.color = "Red";
//
//        System.out.println(otherMic.color);

        //if we call the methods and attributes will be different
//        otherMic.turnOn();
//        otherMic.setVolume();
//        otherMic.turnOff();

        Microphone newMic = new Microphone("NewMic","Green",567);




    }
}