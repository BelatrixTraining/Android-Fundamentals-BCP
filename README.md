# Android-Fundamentals - BCP
Curso de fundamentos de Android - Belatrix BCP

# Instructor

Eduardo José Medina Alfaro

e-mail: emedinaa@gmail.com

github: https://github.com/emedinaa

# Lesson3 

Interfaz de Usuario, layouts , widgets y componentes de material design.

## 1. Revisión general de los Recursos (R)

  - Estructura de un elemento XML :
  
```
    <?xml version="1.0" encoding="utf-8"?>
    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools" android:layout_width="match_parent"
        android:layout_height="match_parent" android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        android:paddingBottom="@dimen/activity_vertical_margin">
    
        <TextView android:text="Hello World!" android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </RelativeLayout>
```

  - ID :
  
```
      android:id="@+id/img"
```

```
      <TextView
            android:id="@+id/txtImg"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Medium Text"
            android:textAppearance="?android:attr/textAppearanceMedium" />
```
    
  - Atributos :
    
```
        android:layout_width="300dp"
```
    
  - En el código podemos invocar a los elementos XML de la siguiente manera :
  
```
      @Override
      protected void onCreate(Bundle savedInstanceState) {
          super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_main);
      }
```
    
```
     private ImageView img;
     private Button btnImg;
     private TextView txtImg;

     img= (ImageView)findViewById(R.id.img);
     btnImg= (Button)findViewById(R.id.butImg);
     txtImg = (TextView)findViewById(R.id.txtImg);
```

## 2. Conocer los Layouts

  * Layouts
  
  - LinearLayout
    
    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/linearlayout.png" height="480">

- RelativeLayout
    
    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/relativelayout.png" height="480">
         
- Listview, GridView , RecyclerView
    
    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/listview.png" height="480">
    
    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/gridview.png" height="480">
    
 - ConstraintLayout
 
   <img src="https://developer.android.com/training/constraint-layout/images/constraint-fail_2x.png" height="360"/>
   
   <img src="https://developer.android.com/training/constraint-layout/images/constraint-fail-fixed_2x.png" height="360"/>
 
## 3. Ejercicios

- LinearLayout
    
    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/linearlayout_sample.png" height="480">
    

    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/linearlayout_horz_sample.png" height="480">
    
    
    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/linearlayout_weight_ver_sample.png" height="480">
    
    
    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/linearlayout_weight_hor_sample.png" height="480">
    
- Login Sample
    
    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/login_sample.png" height="480">
    
    <img src="https://github.com/ISILAndroid/am1_group2016_2/blob/Lesson4/images/login_sample_xml.png" height="480">

# Referencias 

User Interface https://developer.android.com/guide/topics/ui/index.html

Build a simple User Interface https://developer.android.com/training/basics/firstapp/building-ui.html

Android Design https://developer.android.com/design/index.html

Layouts https://developer.android.com/guide/topics/ui/declaring-layout.html

ConstraintLayout https://developer.android.com/training/constraint-layout/index.html

ConstraintLayout examples https://github.com/googlesamples/android-ConstraintLayoutExamples

Layout Editor https://developer.android.com/studio/write/layout-editor.html

Android Inspired UI http://android.inspired-ui.com/

Circular Launcher http://developer.samsung.com/sample-app/view.do?v=S000000004D



