package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {

    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0;
        int count = 0;

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                count++;
            }
        }
        return count == 0 ? 0.0 : (double) totalScore / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();

        for (Pupil pupil : pupils) {
            int totalScore = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                totalScore += subject.score();
            }
            double average = subjects.size() == 0 ? 0.0 : (double) totalScore / subjects.size();
            labels.add(new Label(pupil.name(), average));
        }

        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new HashMap<>();
        Map<String, Integer> subjectCount = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(subject.name(), subjectScores.getOrDefault(subject.name(), 0) + subject.score());
                subjectCount.put(subject.name(), subjectCount.getOrDefault(subject.name(), 0) + 1);
            }
        }

        List<Label> labels = new ArrayList<>();
        for (String subject : subjectScores.keySet()) {
            double average = (double) subjectScores.get(subject) / subjectCount.get(subject);
            labels.add(new Label(subject, average));
        }

        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        Label bestLabel = null;

        for (Pupil pupil : pupils) {
            int totalScore = pupil.subjects().stream().mapToInt(Subject::score).sum();
            if (bestLabel == null || totalScore > bestLabel.score()) {
                bestLabel = new Label(pupil.name(), totalScore);
            }
        }
        return bestLabel;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScores = new HashMap<>();

        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectScores.put(subject.name(),
                        subjectScores.getOrDefault(subject.name(), 0) + subject.score());
            }
        }

        String bestSubjectName = null;
        double maxScore = 0;

        for (Map.Entry<String, Integer> entry : subjectScores.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                bestSubjectName = entry.getKey();
            }
        }

        return bestSubjectName != null ? new Label(bestSubjectName, (double) maxScore) : null;
    }
}