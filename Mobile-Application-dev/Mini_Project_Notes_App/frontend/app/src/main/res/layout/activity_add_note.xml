<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/background_dark"
    android:orientation="vertical"
    android:padding="@dimen/spacing_md">
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_vertical"
        android:orientation="horizontal"
        android:layout_marginBottom="@dimen/spacing_lg">
        <ImageView
            android:id="@+id/ivBack"
            android:layout_width="@dimen/icon_size_lg"
            android:layout_height="@dimen/icon_size_lg"
            android:src="@drawable/ic_back"
            android:contentDescription="@string/content_description_back"
            android:padding="@dimen/spacing_xs" />
        <TextView
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="@string/add_note_title"
            android:textColor="@color/text_primary"
            android:textSize="@dimen/text_lg"
            android:textStyle="bold"
            android:layout_marginStart="@dimen/spacing_sm" />
    </LinearLayout>
    <EditText
        android:id="@+id/etTitle"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@null"
        android:hint="@string/hint_note_title"
        android:inputType="text"
        android:textColor="@color/text_primary"
        android:textColorHint="@color/text_hint"
        android:textSize="@dimen/text_xl"
        android:textStyle="bold"
        android:layout_marginBottom="@dimen/spacing_md"
        android:importantForAutofill="no" />
    <View
        android:layout_width="match_parent"
        android:layout_height="1dp"
        android:background="@color/divider"
        android:layout_marginBottom="@dimen/spacing_md" />
    <EditText
        android:id="@+id/etBody"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:background="@null"
        android:hint="@string/hint_note_body"
        android:inputType="textMultiLine"
        android:gravity="top"
        android:textColor="@color/text_primary"
        android:textColorHint="@color/text_hint"
        android:textSize="@dimen/text_md"
        android:lineSpacingExtra="4dp"
        android:importantForAutofill="no" />
    <Button
        android:id="@+id/btnSave"
        android:layout_width="match_parent"
        android:layout_height="@dimen/button_height"
        android:background="@drawable/rounded_button"
        android:text="@string/btn_save"
        android:textColor="@color/text_on_primary"
        android:textSize="@dimen/text_md"
        android:textStyle="bold"
        android:textAllCaps="false"
        android:layout_marginTop="@dimen/spacing_md" />
    <ProgressBar
        android:id="@+id/progressBar"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:indeterminateTint="@color/amber_primary"
        android:visibility="gone"
        android:layout_marginTop="@dimen/spacing_md" />
</LinearLayout>
