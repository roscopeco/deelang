Deelang - An embeddable scripting language for Android and Java
===============================================================

Deelang is an simple, dynamic, embeddable scripting language for Java that is designed to easily add support for user-scripted actions within a Java application.

When used on Android devices, Deelang can compile directly to DEX bytecode at runtime. A simple VM (with a custom bytecode format) is provided for use in other environments.

Deelang is:
-----------

* **Flexible**: You can easily embed Deelang and provide your users with a custom environment for scripting.
* **Lightweight**: The entire Deelang compiler, VM and runtime weigh in at less that 1MB (including the required ANTLR runtime). On Android, using the `novm` jar will add ~300k to your APK.
* **Intuitive**: Designed for non-expert programmers, Deelang has an easy to read syntax that anyone can pick up with a little guidance.
* **Portable**: Originally designed for use in the Android environment, Deelang should be embeddable anywhere.
* **Compiled**: Deelang scripts compile either to **D**alvik **EX**ecutable (DEX) format, or to a compact, self-contained bytecode format designed for minimal memory usage. The standard distribution supports both via different compiler back-ends and runtime libraries.
* **Free**: Deelang is free to use and distribute, under the Apache License 2.0.

Who can use Deelang?
--------------------

If you're writing or maintaining an application that has a need for a simple, versatile built-in scripting language that allows you to provide users with well-defined extension points against which to write their scripts, then Deelang is for you. Simply code up your extension point objects in Java, register them within your context, then load up a stored compiled script (or compile one afresh) and you're good to go.

Here is some example Deelang code:

```java
Phone.hangUp()

Contacts.find("Ross Bamford") {
  Phone.call(number)
} or {
  Tell.me(why)
}

pic = Camera.take_picture()
pic.save_to_media()

Facebook.share(pic) {
  pic.caption = "I just took this picture!"
  pic.album = "Random pics I took"
} or {
  Facebook.postStatus("took a pic but couldn't upload it :(")
}

Broadcast.intent() { makeIntent("com.roscopeco.someapp.action.FOO", "http://www.google.com/") }
```

The objects referenced in the above code are all simple objects, implemented in Java, that perform whatever work they need to and can interact fully with the other code running in either the Dalvik VM (on Android) or the the Dee virtual machine via Deelang's runtime API.

For more information, including obtaining Deelang, check out [http://deelang.googlecode.com](http://deelang.googlecode.com/)

Deelang is Copyright &copy; Ross Bamford (& contributors) and is Open Source software licensed under the Apache License 2.0. See the included LICENSE file for more details.

