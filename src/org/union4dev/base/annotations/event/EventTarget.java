package org.union4dev.base.annotations;

import com.darkmagician6.eventapi.Priority;
import org.union4dev.base.Access;

import java.lang.annotation.*;

/**
 * Marks a method so that the EventManager knows that it should be registered.
 * The priority of the method is also set with this.
 *
 * @author DarkMagician6
 * @see Priority
 * @since July 30, 2013
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EventTarget {
	byte value() default Priority.MEDIUM;
	Class<?> depend() default Access.class;
}