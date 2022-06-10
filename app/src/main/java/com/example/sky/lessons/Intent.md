## Intent

An Intent is a messaging object that helps your app interact with other app components. You've probably seen one before: for example, when you try to open some file, Android asks you which app you would like to use to open it. In this topic, we will get a deeper understanding of how Intents work.

##### What are Intents?

**Intent** is an object for messaging between the app components and other apps. Simply saying, Intent does the job of telling Android what should be done or has been done. One of the most popular use cases for Intents is launching another activity of your application. It also can be used to tell other applications that your app needs another app to perform some action, for example, get a selected photo from your Photos app. They are also used to broadcast messages across the system: any app is capable of having a broadcast receiver and responding accordingly to this message.

Android broadcasts events, too: when you receive a phone call or a text message, your preferred SMS or Phone app gets an Intent and reacts to it.

##### Intent types

There are two types of intent: **explicit** and **implicit**.

Explicit intents specify which app component should satisfy the intent. This type of intent is normally used inside your app because you know the app's package and the class name of the callee component you want to use. For example, you can start an activity or service by using explicit intents.

Implicit intents are a little bit more abstract. They don't name a specific component to perform the action, so the system will find apps that can perform the required action, and the user will be able to decide which app they would like to use. For example, the app can redirect the user to the specified website, or the end-user will have to choose the browser they would like to use to load the content.

##### Explicit intents

Earlier, we mentioned that explicit intents are most often used inside your app. Let's try to open another activity of your app by creating an Intent.

Say we have two activities: one has a single button that says "Open user profile", and another contains the user data.

<img src="https://ucarecdn.com/d2844a95-7077-4d91-b162-9242063f7d0d/" alt="img" style="zoom:25%;" />

To do that, set `onClickListener` on the button and define the Intent:

```kotlin
button.setOnClickListener {
    val intent = Intent(this, UserActivity::class.java)
    startActivity(intent)
}
```

Here, we explicitly define the context (`this` or `this@NameOfYourActivity`) as the first parameter, and the name of the Activity to which the app should switch as the second parameter. After, we call `startActivity(intentName)`, and we will see the layout we have requested. You can call any activity by its class name using this function.



You need to check whether the activity is defined in the manifest file. If that is not the case, your app will crash at runtime.



You can also put some data in your intent by using the `putExtra()` function. Let's see how it works: using the text from `EditText`, we will change the name of the user on the second screen.

<img src="https://ucarecdn.com/2dfe0635-b418-460a-ac43-d0d4f59fbdd9/" alt="img" style="zoom:25%;" />

In your first activity (the one where you have defined an intent), call the `putExtra()` function:

```kotlin
val intent = Intent(this, UserActivity::class.java)
intent.putExtra("userName", editText.text.toString())
startActivity(intent)
```

The first parameter in this function defines the name of the intent extra. You need to define it to find this data in the activity you launched. In the second activity, we type this:

```kotlin
name.text = intent.getStringExtra("userName")
```

In the `getStringExtra()`, we type in the name of our intent extra as a parameter. Done! We have received our String from the first activity and successfully assigned it to our `TextView` in the second activity.



Functions like `getIntExtra()`, `getBooleanExtra()`, and others require you to set a default value, which will be returned if there's no value associated with the requested key. The default value should be specified as the second parameter. Example: `getIntExtra("number", 0)`; `getBooleanExtra("boolean", false)`.



##### Implicit intents

For implicit intents, we don't need to exactly specify the class name. However, we do need to specify parameters such as action, data, and category.

Before we continue, let's understand what these parameters mean:

- Action specifies the action to perform, for example, `ACTION_VIEW` shows content like websites and photos, `ACTION_SEND` allows users to share data with other apps like social networks, messengers, or e-mail, etc.
- Category contains additional data about the kind of app that should handle the intent. Most intents don't require categories.
- Data is a `Uri` object that references the data and type of that data: a picture, an audio file, a PDF document. URI is a Uniform Resource Identificator, a string that identifies an object that can be reached on specified resource.

Android will start the app suitable for our needs. Let's try to open some website by clicking the button.

<img src="https://ucarecdn.com/7fdb77cb-cb4a-4f50-a486-0db012568b34/" alt="img" style="zoom:25%;" />



```kotlin
val website = Uri.parse("https://hyperskill.org")
val intent = Intent(Intent.ACTION_VIEW, website)
startActivity(intent)


// another way to do this:

val intent = Intent()
intent.action = Intent.ACTION_VIEW
intent.data = Uri.parse("https://hyperskill.org")
intent.addCategory(Intent.CATEGORY_BROWSABLE)
startActivity(intent)
```

The system has started a new activity (default web browser) and specified the website that we wanted to see.

We could also dial some number like this:

```kotlin
val phoneNumber = Uri.parse("tel:(650)555-1212")
val intent = Intent(Intent.ACTION_DIAL, phoneNumber)
startActivity(intent)
```

There's a lot of actions available: if you're curious, you can check them all out in the Android developer [documentation](https://developer.android.com/reference/android/content/Intent.html#standard-activity-actions).

In either of these cases, we didn't specify the app that should perform the action: Android handled that part just fine.

##### Conclusion

In this topic, we've learned the basics of Intents. Now you know the difference between explicit and implicit Intents, how to add data to your Intent, and how to use Intents in your projects. Of course, further on you will learn even more about Intents, but now is a great moment to pause and have some practice.

 