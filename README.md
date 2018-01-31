# Android-Fundamentals - BCP
Curso de fundamentos de Android - Belatrix BCP

# Lesson7 

Fragments, conceptos y comunicación.

- Fragments

- Creating a Fragment

- Fragment Lifecycle

- Communicating with the Activity

- Communication between Fragments

- Exercises

## Conociendo los Fragments

Los fragmentos son vistas con código y diseño(XML) , no necesitan ser registrados en el AndroidManifest y requieren de una actividad como contenedor. Se pueden agregar o quitar a demanda  y tambien cuentan con su propio ciclo de vida. 
Adicional, una actividad puede contener más de un fragment, es decir , por ejemplo, en una pantalla puede tener 2 fragments.
Los fragments se usan para construir componentes reusables, evitando duplicación de recursos y de código , además se usa mucho cuando es requerido que una aplicación funcione tanto en un smartphone y tablets.

![fragments](https://developer.android.com/images/training/basics/fragments-screen-mock.png)

## Creando un Fragment

```java
    import android.os.Bundle;
    import android.support.v4.app.Fragment;
    import android.view.LayoutInflater;
    import android.view.ViewGroup;

    public class ArticleFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.article_view, container, false);
        }
    }
```

Una vez creado un fragment, este puede ser insertado como cualquier componente de diseño 

```xml
  <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
      android:orientation="horizontal"
      android:layout_width="fill_parent"
      android:layout_height="fill_parent">

      <fragment android:name="com.example.android.fragments.HeadlinesFragment"
                android:id="@+id/headlines_fragment"
                android:layout_weight="1"
                android:layout_width="0dp"
                android:layout_height="match_parent" />

      <fragment android:name="com.example.android.fragments.ArticleFragment"
                android:id="@+id/article_fragment"
                android:layout_weight="2"
                android:layout_width="0dp"
                android:layout_height="match_parent" />

</LinearLayout>

```

Para poder insertar el Fragment en un activity por programación

```java
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class MainActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_articles);

        // Check that the activity is using the layout version with
        // the fragment_container FrameLayout
        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            HeadlinesFragment firstFragment = new HeadlinesFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }
}
```

Otra opción podría ser reemplazar un fragment por otro , para lo cual :

```java
  // Create fragment and give it an argument specifying the article it should show
  ArticleFragment newFragment = new ArticleFragment();
  Bundle args = new Bundle();
  args.putInt(ArticleFragment.ARG_POSITION, position);
  newFragment.setArguments(args);

  FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

  // Replace whatever is in the fragment_container view with this fragment,
  // and add the transaction to the back stack so the user can navigate back
  transaction.replace(R.id.fragment_container, newFragment);
  transaction.addToBackStack(null);

  // Commit the transaction
  transaction.commit();
```

## Ciclo de un vida de un Fragment

![fragments](https://developer.android.com/guide/components/images/activity_lifecycle.png)

## Comunicación 

Para poder comunicar un fragment con una actividad(padre) o con otro fragment , usamos interfaces como canal de comunicación

```java
    public class HeadlinesFragment extends ListFragment {
        OnHeadlineSelectedListener mCallback;

        // Container Activity must implement this interface
        public interface OnHeadlineSelectedListener {
            public void onArticleSelected(int position);
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

            // This makes sure that the container activity has implemented
            // the callback interface. If not, it throws an exception
            try {
                mCallback = (OnHeadlineSelectedListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnHeadlineSelectedListener");
            }
        }

        ...
    }
```

La interface puede ser creada de manera independiente o asociada a una actividad con la que se requiere comunicarse

```java
  public static class MainActivity extends Activity
          implements HeadlinesFragment.OnHeadlineSelectedListener{
      ...

      public void onArticleSelected(int position) {
          // The user selected the headline of an article from the HeadlinesFragment
          // Do something here to display that article
      }
  }

```

Enviar parámetros a un Fragment, para lo cual usamos la clase "Bundle"

```java
public static class MainActivity extends Activity
        implements HeadlinesFragment.OnHeadlineSelectedListener{
    ...

    public void onArticleSelected(int position) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article

        ArticleFragment articleFrag = (ArticleFragment)
                getSupportFragmentManager().findFragmentById(R.id.article_fragment);

        if (articleFrag != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            articleFrag.updateArticleView(position);
        } else {
            // Otherwise, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            ArticleFragment newFragment = new ArticleFragment();
            Bundle args = new Bundle();
            args.putInt(ArticleFragment.ARG_POSITION, position);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);

            // Commit the transaction
            transaction.commit();
        }
    }
}
```

# Referencias 

Fragment https://developer.android.com/reference/android/app/Fragment.html

Developer Guides : Fragments https://developer.android.com/guide/components/fragments.html

Building a Dynamic UI with Fragments https://developer.android.com/training/basics/fragments/index.html




