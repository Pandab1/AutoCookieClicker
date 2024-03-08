package eu.pandab.autocookieclicker.utils;

/**
 * The Observer interface provides methods to update the state of a subject.
 */
public interface Observer {
    /**
     * Updates the given subject.
     *
     * @param subj the subject to be updated
     */
    public void update(Subject subj);

    /**
     * Updates the given subject with additional data.
     *
     * @param subj the subject to be updated
     * @param data additional data to update the subject with
     */
    public void update(Subject subj, Object data);
}