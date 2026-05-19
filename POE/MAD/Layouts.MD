

Think of a **layout** as a way to arrange items on the screen.

Buttons, text boxes, images → all need a container that decides:

* where things go
* how much space they take
* how they behave on different screen sizes

---

# 1. LinearLayout

## Idea

Places items in a **single line**:

* vertically (`top → bottom`)
  OR
* horizontally (`left → right`)

Think:

```text
Item 1
Item 2
Item 3
```

or

```text
Item1 Item2 Item3
```

---

## When to Use

Use when UI is simple and arranged in one direction.

Examples:

* Login form
* Simple menu
* Vertical buttons

---

## Important Attribute

```xml
android:orientation="vertical"
```

OR

```xml
android:orientation="horizontal"
```

---

## Example

```xml id="8f21a"
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Name"/>

    <EditText
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Password"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Login"/>

</LinearLayout>
```

---

# 2. RelativeLayout

## Idea

Places items **relative to each other**.

Examples:

* below another view
* beside another view
* centered

Think:

```text
Button BELOW textbox
Image RIGHT OF text
```

---

## When to Use

When positioning matters.

---

## Important Attributes

```xml
android:layout_below="@id/name"
android:layout_centerHorizontal="true"
android:layout_toRightOf="@id/image"
```

---

## Example

```xml id="j2k7m"
<RelativeLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/title"
        android:text="Login"
        android:textSize="24sp"
        android:layout_centerHorizontal="true"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <EditText
        android:id="@+id/name"
        android:hint="Name"
        android:layout_below="@id/title"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

</RelativeLayout>
```

---

# 3. AbsoluteLayout

## Idea

Places items using **fixed X-Y coordinates**.

Example:

```text
Button at x=100 y=200
```

---

## VERY IMPORTANT

⚠️ `AbsoluteLayout` is deprecated.

Google no longer recommends it because:

* different phones have different screen sizes
* UI breaks easily

Still taught in colleges for basics.

---

## Example

```xml id="l4s9p"
<AbsoluteLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:layout_x="100dp"
        android:layout_y="150dp"
        android:text="Click"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</AbsoluteLayout>
```

---

# 4. ListView

## Idea

Displays a **scrollable list**.

Think:

```text
Apple
Banana
Mango
Orange
```

---

## When to Use

For menus or long lists.

---

## XML

```xml id="z6v8c"
<ListView
    android:id="@+id/listView"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

---

## Java Code

```java id="r5t2x"
ListView listView = findViewById(R.id.listView);

String[] fruits = {
        "Apple",
        "Banana",
        "Mango",
        "Orange"
};

ArrayAdapter<String> adapter =
        new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                fruits
        );

listView.setAdapter(adapter);
```

---

# 5. TableLayout

## Idea

Arranges items in **rows and columns** like a table.

Think:

| Name  | Age |
| ----- | --- |
| Soham | 20  |

---

## Structure

* `TableLayout`
* inside it → `TableRow`

---

## Example

```xml id="y7h3n"
<TableLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TableRow>

        <TextView
            android:text="Name"/>

        <TextView
            android:text="Age"/>
    </TableRow>

    <TableRow>

        <TextView
            android:text="Soham"/>

        <TextView
            android:text="20"/>
    </TableRow>

</TableLayout>
```

---

# 6. GridLayout

## Idea

Places items in a **grid format**.

Think calculator:

```text
1 2 3
4 5 6
7 8 9
```

---

## When to Use

* Calculator
* Gallery
* Menu icons

---

## Important Attribute

```xml
android:columnCount="3"
```

---

## Example

```xml id="g1m4q"
<GridLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:columnCount="3">

    <Button android:text="1"/>
    <Button android:text="2"/>
    <Button android:text="3"/>
    <Button android:text="4"/>
    <Button android:text="5"/>
    <Button android:text="6"/>

</GridLayout>
```

---

# 7. FrameLayout

## Idea

Stacks items **on top of each other**.

Think layers:

```text
Image
Text over image
Button over text
```

---

## When to Use

* Fragments
* Image overlays
* Loading screens

---

## Example

```xml id="p8d5r"
<FrameLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <ImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@mipmap/ic_launcher"/>

    <TextView
        android:text="Hello"
        android:textSize="30sp"
        android:layout_gravity="center"/>

</FrameLayout>
```

---

# MOST IMPORTANT DIFFERENCE

| Layout         | Arranges Views How?    | Best For           |
| -------------- | ---------------------- | ------------------ |
| LinearLayout   | In one line            | Forms              |
| RelativeLayout | Relative to each other | Flexible UI        |
| AbsoluteLayout | Fixed positions        | Rarely used        |
| ListView       | Scrollable list        | Lists              |
| TableLayout    | Rows & columns         | Table data         |
| GridLayout     | Grid                   | Calculator/gallery |
| FrameLayout    | Stack views            | Overlays/fragments |

---

# How Android Layouts Actually Work

Every screen has:

```text
Activity
   ↓
Layout XML
   ↓
Views (Button/TextView/etc)
```

Example:

```text
MainActivity.java
       ↓
activity_main.xml
       ↓
Button + TextView + EditText
```

---

# How To Implement Any Layout

## Step 1

Create new Android project.

---

## Step 2

Open:

```text
res → layout → activity_main.xml
```

---

## Step 3

Replace root layout:

Example:

```xml
<LinearLayout>
```

OR

```xml
<RelativeLayout>
```

---

## Step 4

Add views inside.

Example:

```xml
<Button/>
<TextView/>
<EditText/>
```

---

## Step 5

Connect with Java

```java id="t3b6w"
Button btn = findViewById(R.id.btn);
```

---

## Step 6

Run app.

---

# Modern Android Note

Nowadays developers mostly use:

* `ConstraintLayout`
* `RecyclerView`
* Jetpack Compose

But learning these classic layouts is VERY important because:

* colleges ask them
* interviews ask basics
* they teach UI logic clearly

---

# Easy Memory Trick

| Layout   | Imagine            |
| -------- | ------------------ |
| Linear   | Queue              |
| Relative | Map directions     |
| Absolute | Coordinates        |
| ListView | WhatsApp chat list |
| Table    | Excel sheet        |
| Grid     | Calculator         |
| Frame    | Stack of papers    |

---

# Best Way To Practice

Build:

1. Login form → LinearLayout
2. Calculator → GridLayout
3. Student marks table → TableLayout
4. Photo overlay → FrameLayout
5. Menu list → ListView

That’s how layouts become natural.
