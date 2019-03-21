package com.tyler.main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class statistics extends Application {

    Label wordCount, characterCount, spaceCount, periodCount, commaCount, totalPercentageVowels, shortestWords, longestWords, averageWordLength;
    File inFile, outFile;

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox main = new VBox();
        VBox column = new VBox();

        main.getChildren().add(column);

        wordCount = new Label("Word Count: ");
        characterCount = new Label("Space Count: ");
        spaceCount = new Label("Space Count: ");
        periodCount = new Label("Period Count: ");
        commaCount = new Label("Comma Count: ");
        totalPercentageVowels = new Label("Total Percentage Vowels: ");
        shortestWords = new Label("Shortest Words: ");
        longestWords = new Label("Longest Words: ");
        averageWordLength = new Label("Average Word Length: ");

        Button browseButton = new Button("Browse");
        browseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                inFile = fileChooser.showOpenDialog(primaryStage);

                wordCount.setText("Word Count: " + wordCountMethod(inFile));
                characterCount.setText("Character Count: " + characterCountMethod(inFile));
                spaceCount.setText("Space Count: " + spaceCountMethod(inFile));
                periodCount.setText("Period Count: " + periodCountMethod(inFile));
                commaCount.setText("Comma Count: " + commaCountMethod(inFile));
                totalPercentageVowels.setText("Total Percentage Vowels:" + totalPercentageVowelsMethod(inFile));
                shortestWords.setText("Shortest Words:" + shortestWordsMethod(inFile));
                longestWords.setText("Longest Words: " + longestWordsMethod(inFile));
                averageWordLength.setText("Average Word Length: " + averageWordLengthMethod(inFile));
            }
        });

        Button saveAlphabeticalWordList = new Button("Save Alphabetical Word List");
        saveAlphabeticalWordList.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                outFile = new File("./AlphabeticalList.txt");

                if (!outFile.exists()) {
                    try {
                        outFile.createNewFile();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                String fileContents = "";
                String[] words = new String[0];
                try {
                    FileInputStream fileRead = new FileInputStream(inFile);
                    Scanner scanner = new Scanner(fileRead);
                    while (scanner.hasNext()) {
                        fileContents += scanner.nextLine();
                        words = fileContents.split("[ ]|[,]|\\n|[.]");
                    }
                    for (int i = 0; i < words.length; i++) {
                        words[i] = words[i].toLowerCase();
                    }
                    HashSet<String> finalList = new HashSet<String>();
                    for (int i = 0; i < words.length; i++) {
                        finalList.add(words[i]);
//                        System.out.println(words[i]);
                    }
                    ArrayList<String> ultimateFinalList = new ArrayList<String>();
                    FileWriter fileWrite = new FileWriter(outFile, true);
                    for (String word : finalList) {
                        if (word.length() > 0) {
                            ultimateFinalList.add(word);
                        }
                    }
                    Collections.sort(ultimateFinalList);
                    for (int i = 0; i < ultimateFinalList.size(); i++) {
                        fileWrite.write(ultimateFinalList.get(i) + "\n");
                    }
                    fileWrite.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


        column.getChildren().addAll(browseButton, wordCount, characterCount, spaceCount, periodCount, commaCount,
                totalPercentageVowels, shortestWords, longestWords, averageWordLength, saveAlphabeticalWordList);

        Scene scn = new Scene(main, 700, 400);
        primaryStage.setScene(scn);
        primaryStage.setTitle("Text Statistics");
        primaryStage.show();
    }



    int wordCountMethod(File mainFile) {
        String fileContents = "";
        int amount = 0;
        try {
            FileInputStream inputStream = new FileInputStream(mainFile);
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                fileContents += scanner.nextLine();
            }
            String regex = "\\w+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileContents);
            while (matcher.find()) {
                amount++;
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    int characterCountMethod(File mainFile) {
        String fileContents = "";
        int amount = 0;
        try {
            FileInputStream inputStrem = new FileInputStream(mainFile);
            Scanner scanner = new Scanner(inputStrem);
            while (scanner.hasNext()) {
                fileContents += scanner.nextLine();
            }
            String regex = "([A-Za-z])";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileContents);
            while (matcher.find()) {
                amount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    int spaceCountMethod(File mainFile) {
        String fileContents = "";
        int amount = 0;
        try {
            FileInputStream inputStrem = new FileInputStream(mainFile);
            Scanner scanner = new Scanner(inputStrem);
            while (scanner.hasNext()) {
                fileContents += scanner.nextLine();
            }
            String regex = " ";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileContents);
            while (matcher.find()) {
                amount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    int periodCountMethod(File mainFile) {
        String fileContents = "";
        int amount = 0;
        try {
            FileInputStream inputStrem = new FileInputStream(mainFile);
            Scanner scanner = new Scanner(inputStrem);
            while (scanner.hasNext()) {
                fileContents += scanner.nextLine();
            }
            String regex = "\\.";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileContents);
            while (matcher.find()) {
                amount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    int commaCountMethod(File mainFile) {
        String fileContents = "";
        int amount = 0;
        try {
            FileInputStream inputStrem = new FileInputStream(mainFile);
            Scanner scanner = new Scanner(inputStrem);
            while (scanner.hasNext()) {
                fileContents += scanner.nextLine();
            }
            String regex = ",";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileContents);
            while (matcher.find()) {
                amount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    float totalPercentageVowelsMethod(File mainFile) {
        String fileContents = "";
        int vowelAmount = 0;
        int characterAmount = 0;
        float amount = 0;
        try {
            FileInputStream inputStrem = new FileInputStream(mainFile);
            Scanner scanner = new Scanner(inputStrem);
            while (scanner.hasNext()) {
                fileContents += scanner.nextLine();
            }
            String vowelRegex = "([AEIOUYaeiouy])";
            Pattern vowelPattern = Pattern.compile(vowelRegex);
            Matcher vowelMatcher = vowelPattern.matcher(fileContents);
            while (vowelMatcher.find()) {
                vowelAmount++;
            }

            amount = ((float)vowelAmount/(float)characterCountMethod(mainFile)) * 100;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return amount;
    }

    String shortestWordsMethod(File mainFile) {
        String fileContents = "";
        String shortestWords = "";
        ArrayList<String> wordList = new ArrayList<String>();
        try {
            FileInputStream inputStrem = new FileInputStream(mainFile);
            Scanner scanner = new Scanner(inputStrem);
            while (scanner.hasNext()) {
                fileContents += scanner.nextLine();
            }
            String regex = "\\w+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileContents);
            while (matcher.find()) {
                wordList.add(matcher.group().toLowerCase());
            }
            int shortestLength = 10000;
            HashSet<String> hashWords = new HashSet();
            for (int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).length() < shortestLength) {
                    hashWords.clear();
                    hashWords.add(wordList.get(i));
                    shortestLength = wordList.get(i).length();
                } else if (wordList.get(i).length() == shortestLength){
                    hashWords.add(wordList.get(i));
                }
            }

            for (String s : hashWords) {
                shortestWords += s + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return shortestWords;
    }

    String longestWordsMethod(File mainFile) {
        String fileContents = "";
        String longestWords = "";
        ArrayList<String> wordList = new ArrayList<String>();
        try {
            FileInputStream inputStrem = new FileInputStream(mainFile);
            Scanner scanner = new Scanner(inputStrem);
            while (scanner.hasNext()) {
                fileContents += scanner.nextLine();
            }
            String regex = "\\w+";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(fileContents);
            while (matcher.find()) {
                wordList.add(matcher.group().toLowerCase());
            }
            int longestLength = 0;
            HashSet<String> hashWords = new HashSet();
            for (int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).length() > longestLength) {
                    hashWords.clear();
                    hashWords.add(wordList.get(i));
                    longestLength = wordList.get(i).length();
                } else if (wordList.get(i).length() == longestLength){
                    hashWords.add(wordList.get(i));
                }
            }

            for (String s : hashWords) {
                longestWords += s + " ";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return longestWords;
    }

    float averageWordLengthMethod(File mainFile) {
        float averageWord = (float)characterCountMethod(mainFile) / (float)wordCountMethod(mainFile);

        return  averageWord;
    }

}
