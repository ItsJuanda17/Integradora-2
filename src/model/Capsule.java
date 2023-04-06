/**
 * The Capsule class represents a single capsule of knowledge, which contains information about a particular situation or experience that has been turned into a lesson learned. It contains information such as a unique identifier, the situation description, the type of capsule, the author's name and position, the lesson learned, a list of hashtags, and whether the capsule has been approved and published.
 */


package model;
import java.security.SecureRandom;
import java.lang.Integer;
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

/**
 * Returns a string representing a constant size.
 *
 * @return a string representing a constant size.
 */
public static String SIZEC(){
    return "6";
}


/**
     * Creates a new Capsule object with the specified situation description, capsule type, author name, author position, and lesson learned.
     * @param situationDescription A description of the situation or experience that the capsule is based on.
     * @param capsuleType The type of capsule (e.g. personal experience, customer feedback, etc.).
     * @param authorName The name of the author of the capsule.
     * @param authorPosition The position of the author of the capsule.
     * @param lessonLearned The lesson learned from the situation or experience.
     */

public Capsule(String situationDescription, int capsuleType, String authorName, String authorPosition, String lessonLearned) {
    SecureRandom random = new SecureRandom();
    byte[] bytes = new byte[4];
    random.nextBytes(bytes);
    id = Math.abs(bytesToInt(bytes));
    
    
    // Initialize the instance variables with the provided values
    this.situationDescription = situationDescription;
    this.capsuleType = capsuleType;
    this.authorName = authorName;
    this.authorPosition = authorPosition;
    this.lessonLearned = lessonLearned;
    
 /**
 * Initializes a new string array called `hashtags` with a size of 6, which is obtained by parsing
 * the string returned by the `SIZEC()` method. Calls the `initHashtags()` method after the `hashtags`
 * array has been initialized.
 */
    hashtags = new String[Integer.parseInt(SIZEC())];
    initHashtags();
    
    // Set the approved and published flags to false
    approved = false;
    published = false;
    
     // Generate a unique URL for the capsule using a UUID
    UUID urlBase = UUID.randomUUID();
    url = urlBase.toString();
}



    /**
     * Converts a byte array to an integer.
     * @param bytes the byte array to convert
     * @return the integer representation of the byte array
     */
private int bytesToInt(byte[] bytes) {
    int value = 0;
    for (int i = 0; i < bytes.length; i++) {
        value += bytes[i] << (i * 8);
    }
    return value;
}

 /**
     * Initializes the hashtags array to empty strings.
     */
public void initHashtags() {
    for (int i = 0; i < hashtags.length; i++) {
        hashtags[i] = "";
    }
    hashtagCounter = 0;
}


/**
     * Extracts hashtags from the lesson learned and adds them to the hashtags array.
     * @param lesson the lesson learned from the capsule
     */
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
 /**
     * Extracts hashtags from the situation description and adds them to the hashtags array.
     * @param situation the situation that led to the knowledge being shared
     */
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

/**

Returns the ID of the capsule.
@return the ID of the capsule.
*/


public int getId() {
    return id;
}

/**

Returns the situation description of the capsule.
@return the situation description of the capsule.
*/

public String getSituationDescription() {
    return situationDescription;
}


/**

Sets the situation description of the capsule.
@param situationDescription the new situation description for the capsule.
*/
public void setSituationDescription(String situationDescription) {
    this.situationDescription = situationDescription;
}


/**

Returns the type of the capsule.
@return the type of the capsule.
*/
public int getCapsuleType() {
    return capsuleType;
}

/**

Sets the type of the capsule.
@param capsuleType the new type for the capsule.
*/
public void setCapsuleType(int capsuleType) {
    this.capsuleType = capsuleType;
}

/**

Returns the name of the author of the capsule.
@return the name of the author of the capsule.
*/

public String getAuthorName() {
    return authorName;
}

/**

Sets the name of the author of the capsule.
@param authorName the new name for the author of the capsule.
*/

public void setAuthorName(String authorName) {
    this.authorName = authorName;
}

/**

Returns the position of the author of the capsule.
@return the position of the author of the capsule.
*/

public String getAuthorPosition() {
    return authorPosition;
}


/**

Sets the position of the author of the capsule.
@param authorPosition the new position for the author of the capsule.
*/
public void setAuthorPosition(String authorPosition) {
    this.authorPosition = authorPosition;
}


/**

Returns the lesson learned of the capsule.
@return the lesson learned of the capsule.
*/
public String getLessonLearned() {
    return lessonLearned;
}

/**

Sets the lesson learned of the capsule.
@param lessonLearned the new lesson learned for the capsule.
*/
public void setLessonLearned(String lessonLearned) {
    this.lessonLearned = lessonLearned;
}

/**

Returns the hashtags of the capsule.
@return the hashtags of the capsule.
*/
public String[] getHashtags() {
    return hashtags;
}

/**

Returns whether the capsule has been approved or not.
@return true if the capsule has been approved, false otherwise.
*/
public boolean isApproved() {
    return approved;
}


/**

Sets whether the capsule has been approved or not.
@param approved true if the capsule has been approved, false otherwise.
*/
public void setApproved(boolean approved) {
    this.approved = approved;
}

/**

Returns whether the capsule has been published or not.
@return true if the capsule has been published, false otherwise.
*/
public boolean isPublished() {
    return published;
}

/**

Sets whether the capsule has been published or not.
@param published true if the capsule has been published, false otherwise.
*/
public void setPublished(boolean published) {
    this.published = published;
}

/**

Returns the URL of the capsule.
@return the URL of the capsule.
*/
public String getUrl() {
    return url;
}


}