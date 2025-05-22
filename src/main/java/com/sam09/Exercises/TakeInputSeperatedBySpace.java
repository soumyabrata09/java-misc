package com.sam09.Exercises;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class TakeInputSeperatedBySpace {
    private static final Logger log = LoggerFactory.getLogger(TakeInputSeperatedBySpace.class);
    private Long startTime;
    private Long endTime;

    public TakeInputSeperatedBySpace() {
        startTime = null;
        endTime = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TakeInputSeperatedBySpace that = (TakeInputSeperatedBySpace) o;
        return Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }

    @Override
    public String toString() {
        return "TakeInputSeperatedBySpace{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getTotalTimeTaken() {
        return (endTime - startTime);
    }

    public static void main(String arg[]) {
        TakeInputSeperatedBySpace object = new TakeInputSeperatedBySpace();
        System.out.println("Give Input: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        object.setStartTime(System.currentTimeMillis());
        StringTokenizer tokenizer = new StringTokenizer(str," ");

        while (tokenizer.hasMoreTokens()) {
            System.out.println("Extracted Data: " + tokenizer.nextToken());
        }
        System.out.println("Provide two ints: " );
//        scanner = null;
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        log.info("Modulus Result of " + a + "%" + b + ": " + (a%b));
        object.setEndTime(System.currentTimeMillis());

        log.info("Time Taken to execute the overall process: " + object.getTotalTimeTaken() +"ms");
    }
}
