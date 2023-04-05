package model;
import java.security.SecureRamdom;
import java.lang,Integer;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Capsule{
//atributos
private int id;
private String situationDescription;
private int capsuleType;
private String authorName;
private String authorPosition;
private String lessonLearned;
private String[] hashtags;
private boolean approved;
private boolean published;
private String url;
private int hashtagCounter;
public static final String SIZEC = 6;

public Capsule(String situationDescription, int capsuleType, String authorName, String authorPosition, String lessonLearned) {
    SecureRandom random = new SecureRandom();
    byte[] bytes = new byte[4];
    random.nextBytes(bytes);
    id = Math.abs(bytesToInt(bytes));
    this.situationDescription = situationDescription;
    this.capsuleType = capsuleType;
    this.authorName = authorName;
    this.authorPosition = authorPosition;
    this.lessonLearned = lessonLearned;
    int sizeC= Integer.parseInt(SIZEC);
    hashtags = new String[SIZEC];
    initHashtags();
    approved = false;
    published = false;
    UUID urlBase = UUID.randomUUID();
    url = urlBase.toString();
}

private int bytesToInt(byte[] bytes) {
    int value = 0;
    for (int i = 0; i < bytes.length; i++) {
        value += bytes[i] << (i * 8);
    }
    return value;
}


public void initHashtags() {
    for (int i = 0; i < hashtags.length; i++) {
        hashtags[i] = "";
    }
    hashtagCounter = 0;
}

public void extractLessonHashtags(String lesson) {
    if (lesson == null) {
        return;
    }
    Matcher matcher = Pattern.compile("(?<=#)(\\w+)(?=#)").matcher(lesson);
    while (matcher.find()) {
        String word = matcher.group();
        if (word != null) {
            hashtags[hashtagCounter] = word;
            hashtagCounter++;
        }
    }
}

public void extractSituationHashtags(String situation) {
    if (situation == null) {
        return;
    }
    Matcher matcher = Pattern.compile("(?<=#)(\\w+)(?=#)").matcher(situation);
    while (matcher.find()) {
        String word = matcher.group();
        if (word != null) {
            hashtags[hashtagCounter] = word;
            hashtagCounter++;
        }
    }
}


public int getId() {
    return id;
}

public String getSituationDescription() {
    return situationDescription;
}

public void setSituationDescription(String situationDescription) {
    this.situationDescription = situationDescription;
}

public int getCapsuleType() {
    return capsuleType;
}

public void setCapsuleType(int capsuleType) {
    this.capsuleType = capsuleType;
}

public String getAuthorName() {
    return authorName;
}

public void setAuthorName(String authorName) {
    this.authorName = authorName;
}

public String getAuthorPosition() {
    return authorPosition;
}

public void setAuthorPosition(String authorPosition) {
    this.authorPosition = authorPosition;
}

public String getLessonLearned() {
    return lessonLearned;
}

public void setLessonLearned(String lessonLearned) {
    this.lessonLearned = lessonLearned;
}

public String[] getHashtags() {
    return hashtags;
}

public boolean isApproved() {
    return approved;
}

public void setApproved(boolean approved) {
    this.approved = approved;
}

public boolean isPublished() {
    return published;
}

public void setPublished(boolean published) {
    this.published = published;
}

public String getUrl() {
    return url;
}


}