# Android-Fundamentals - BCP
Curso de fundamentos de Android - Belatrix BCP

# Instructor

Eduardo José Medina Alfaro

e-mail: emedinaa@gmail.com

github: https://github.com/emedinaa

# Lesson4 

Eventos de usuario.

## 1. UI components

- Buttons
- Checkboxes
- Radio buttons
- Campos de textos y labels
- Spinners
- Pickers

## 1. Conocer los eventos de usuario

### Eventos

```java
 btnSignUp =(Button)findViewById(R.id.btnSignUp);
 
 ...
 
   btnSignUp.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            //action
        }
  });
```

```java
  rbGenero.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
              @Override
              public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                  switch (checkedId) {
                      case R.id.rbM:
                          genero = 1;
                          break;
                      case R.id.rbF:
                          genero = 2;
                          break;
                  }
              }
  });
```

```java

  spLocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
              @Override
              public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                  Log.v("CONSOLE", "spLocation" + adapterView.getAdapter().getItem(i));
                  localidad = adapterView.getAdapter().getItem(i).toString();
              }

              @Override
              public void onNothingSelected(AdapterView<?> adapterView) {

              }
          });
  }
```

# Referencias 

User Events https://developer.android.com/guide/topics/ui/ui-events.html



