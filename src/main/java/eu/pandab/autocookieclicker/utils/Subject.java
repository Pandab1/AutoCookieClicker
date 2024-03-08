package eu.pandab.autocookieclicker.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * A Subject represents an abstract class that serves as the basis for implementing the observer pattern.
 * <p>
 * Subclasses of Subject can register themselves as observers and notify all registered observers when a change occurs.
 */
public abstract class Subject {
    /**
     * The list of observers attached to the subject.
     */
    protected List<Observer> attached;

    /**
     * Creates a new instance of the Subject class.
     * This constructor initializes an empty ArrayList of attached objects.
     */
    protected Subject() {
        attached = new ArrayList<>();
    }

    /**
     * Attaches an Observer object to this subject.
     * If the Observer object is not already attached, it is added to the list of attached objects.
     *
     * @param obs The Observer object to be attached to this subject
     */
    public void attach(Observer obs) {
        if (!attached.contains(obs)) {
            attached.add(obs);
        }
    }

    /**
     * Detaches an Observer object from this subject.
     * If the Observer object is attached, it is removed from the list of attached objects.
     *
     * @param obs The Observer object to be detached from this subject
     */
    public void detach(Observer obs) {
        attached.remove(obs);
    }

    /**
     * Notifies all attached Observer objects that a change has occurred in this subject.
     * Calls the update() method on each attached Observer object.
     *
     * <p>
     * This method iterates through the list of attached Observer objects and calls the update() method on each one,
     * passing this subject as the argument.
     * </p>
     *
     * <p>
     * Note: The attached Observer objects should implement the Observer interface and define the update() method.
     * </p>
     *
     * @see Observer
     * @see Observer#update(Subject)
     */
    protected void notifyObservers() {
        for (Observer o : attached) {
            o.update(this);
        }
    }

    /**
     * Notifies all attached Observer objects that a change has occurred in this subject, with the provided data.
     * Calls the update() method on each attached Observer object, passing this subject and the provided data as arguments.
     *
     * <p>
     * This method iterates through the list of attached Observer objects and calls the update() method on each one,
     * passing this subject and the provided data as arguments.
     * </p>
     *
     * <p>
     * Note: The attached Observer objects should implement the Observer interface and define the update() method
     * that accepts two arguments: the Subject object and the data object.
     * </p>
     *
     * @param data the data associated with the change in this subject
     *
     * @see Observer
     * @see Observer#update(Subject, Object)
     */
    protected void notifyObservers(Object data) {
        for (Observer o : attached) {
            o.update(this, data);
        }
    }
}