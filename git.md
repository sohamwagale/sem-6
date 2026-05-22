# Minimal Android Java Programs (Latest Android Studio)

---

# 4. Relative Layout

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }
}
```

## activity_main.xml
```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/txt"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Relative Layout"
        android:layout_centerHorizontal="true"/>

    <Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:layout_below="@id/txt"/>

</RelativeLayout>
```

---

# 5. Absolute Layout

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }
}
```

## activity_main.xml
```xml
<AbsoluteLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Absolute Layout"
        android:layout_x="50dp"
        android:layout_y="50dp"/>

</AbsoluteLayout>
```

---

# 6. ListView

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        ListView lv = findViewById(R.id.lv);
        String[] data = {"Java", "Python", "Android"};

        lv.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, data));
    }
}
```

## activity_main.xml
```xml
<ListView xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/lv"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>
```

---

# 7. Table Layout

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }
}
```

## activity_main.xml
```xml
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TableRow>
        <TextView android:text="Name"/>
        <EditText/>
    </TableRow>

</TableLayout>
```

---

# 8. Grid Layout

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }
}
```

## activity_main.xml
```xml
<GridLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:columnCount="2">

    <Button android:text="1"/>
    <Button android:text="2"/>
    <Button android:text="3"/>
    <Button android:text="4"/>

</GridLayout>
```

---

# 9. Frame Layout

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }
}
```

## activity_main.xml
```xml
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Frame Layout"/>

</FrameLayout>
```

---

# 10. Implicit Intent

## MainActivity.java
```java
package com.example.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(v -> {
            Intent i = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://google.com"));
            startActivity(i);
        });
    }
}
```

## activity_main.xml
```xml
<Button xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/btn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Open Google"/>
```

---

# 11. Explicit Intent

## MainActivity.java
```java
package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(v -> {
            startActivity(new Intent(this, SecondActivity.class));
        });
    }
}
```

## SecondActivity.java
```java
package com.example.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.second);
    }
}
```

## activity_main.xml
```xml
<Button xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/btn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Next"/>
```

## second.xml
```xml
<TextView xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Second Activity"/>
```

---

# 12. Registration Form

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        ToggleButton t = findViewById(R.id.toggle);
        TextView tv = findViewById(R.id.tv);

        findViewById(R.id.btn).setOnClickListener(v -> {
            tv.setText(t.isChecked() ? "ON" : "OFF");
        });
    }
}
```

## activity_main.xml
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText android:hint="Name"/>

    <RadioButton android:text="Male"/>

    <CheckBox android:text="Music"/>

    <ToggleButton
        android:id="@+id/toggle"
        android:textOn="ON"
        android:textOff="OFF"/>

    <Button
        android:id="@+id/btn"
        android:text="Submit"/>

    <TextView android:id="@+id/tv"/>

</LinearLayout>
```

---

# 13. Spinner

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        Spinner s = findViewById(R.id.spinner);
        TextView tv = findViewById(R.id.tv);

        String[] data = {"Java", "Python"};

        s.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, data));

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> p, android.view.View v, int i, long l) {
                tv.setText(data[i]);
            }
            public void onNothingSelected(AdapterView<?> p) {}
        });
    }
}
```

## activity_main.xml
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Spinner android:id="@+id/spinner"/>
    <TextView android:id="@+id/tv"/>

</LinearLayout>
```

---

# 14. Alert Dialog

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import androidx.appcompat.app.*;

public class MainActivity extends AppCompatActivity {
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(v -> {
            new AlertDialog.Builder(this)
                    .setTitle("Exit")
                    .setMessage("Close App?")
                    .setPositiveButton("Yes", (d, i) -> finish())
                    .show();
        });
    }
}
```

## activity_main.xml
```xml
<Button xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/btn"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="Show Dialog"/>
```

---

# 15. Options Menu

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import android.view.*;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu m) {
        m.add("Home");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem i) {
        Toast.makeText(this, i.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
```

---

# 16. Context Menu

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import android.view.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);
        TextView tv = new TextView(this);
        tv.setText("Long Press");
        setContentView(tv);
        registerForContextMenu(tv);
    }

    public void onCreateContextMenu(ContextMenu m, View v, ContextMenu.ContextMenuInfo i) {
        m.add("Edit");
    }

    public boolean onContextItemSelected(MenuItem i) {
        Toast.makeText(this, i.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
```

---

# 17. Popup Menu

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        Button btn = new Button(this);
        btn.setText("Menu");
        setContentView(btn);

        btn.setOnClickListener(v -> {
            PopupMenu p = new PopupMenu(this, btn);
            p.getMenu().add("Edit");
            p.setOnMenuItemClickListener(i -> {
                Toast.makeText(this, i.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });
            p.show();
        });
    }
}
```

---

# 18. Notification

## MainActivity.java
```java
package com.example.app;

import android.app.*;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        NotificationChannel c = new NotificationChannel(
                "id", "test", NotificationManager.IMPORTANCE_DEFAULT);

        getSystemService(NotificationManager.class)
                .createNotificationChannel(c);

        Notification n = new NotificationCompat.Builder(this, "id")
                .setContentTitle("Hello")
                .setContentText("Notification")
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .build();

        getSystemService(NotificationManager.class).notify(1, n);
    }
}
```

---

# 19. SQLite Insert

## MainActivity.java
```java
package com.example.app;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS Student(name TEXT)");

        db.execSQL("INSERT INTO Student VALUES('Soham')");
    }
}
```

---

# 20. SQLite Display

## MainActivity.java
```java
package com.example.app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        TextView tv = new TextView(this);
        setContentView(tv);

        SQLiteDatabase db = openOrCreateDatabase("MyDB", MODE_PRIVATE, null);

        Cursor c = db.rawQuery("SELECT * FROM Student", null);

        c.moveToFirst();
        tv.setText(c.getString(0));
    }
}
```

---

# 21. File Storage

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        try {
            FileOutputStream f = openFileOutput("test.txt", MODE_PRIVATE);
            f.write("Hello".getBytes());
            f.close();
        } catch (Exception e) {}
    }
}
```

---

# 22. Progress Bar

## MainActivity.java
```java
package com.example.app;

import android.os.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout l = new LinearLayout(this);
        l.setOrientation(1);

        ProgressBar p = new ProgressBar(this, null,
                android.R.attr.progressBarStyleHorizontal);

        TextView tv = new TextView(this);

        l.addView(p);
        l.addView(tv);

        setContentView(l);

        new Handler().postDelayed(() -> {
            p.setProgress(50);
            tv.setText("50%");
        }, 1000);
    }
}
```

---

# 23. Rating Bar

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout l = new LinearLayout(this);
        l.setOrientation(1);

        RatingBar r = new RatingBar(this);
        TextView tv = new TextView(this);

        l.addView(r);
        l.addView(tv);

        setContentView(l);

        r.setOnRatingBarChangeListener((a, v, f) -> tv.setText("Rating: " + v));
    }
}
```

---

# 24. Toggle Button

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        ToggleButton t = new ToggleButton(this);
        TextView tv = new TextView(this);

        LinearLayout l = new LinearLayout(this);
        l.setOrientation(1);

        l.addView(t);
        l.addView(tv);

        setContentView(l);

        t.setOnCheckedChangeListener((a, v) ->
                tv.setText(v ? "ON" : "OFF"));
    }
}
```

---

# 25. Calculator

## MainActivity.java
```java
package com.example.app;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle b) {
        super.onCreate(b);

        setContentView(R.layout.activity_main);

        EditText a = findViewById(R.id.a);
        EditText c = findViewById(R.id.b);
        TextView r = findViewById(R.id.r);

        findViewById(R.id.btn).setOnClickListener(v -> {
            int x = Integer.parseInt(a.getText().toString());
            int y = Integer.parseInt(c.getText().toString());
            r.setText("Result: " + (x + y));
        });
    }
}
```

## activity_main.xml
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <EditText
        android:id="@+id/a"
        android:hint="A"/>

    <EditText
        android:id="@+id/b"
        android:hint="B"/>

    <Button
        android:id="@+id/btn"
        android:text="Add"/>

    <TextView android:id="@+id/r"/>

</LinearLayout>
```

