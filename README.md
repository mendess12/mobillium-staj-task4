# mobillium-staj-task4

### Konu 
<pre>Bir API'dan verilerin alınarak bir liste olarak ekranda gösterilmesi.<br>Listedeki itemlara tıklandığında bir detay sayfasına gidilmesi<br>Detay sayfasında listede tıklanan item'in detaylı verilerini ekranda göstermek.</pre>
<hr>

### API 
* [Crypto API](https://www.coingecko.com/en/api/documentation)
<hr>

### Teknolojiler
💻 Network istekleri için Retrofit,<br>
🎑 İmage yüklemek için Picasso,<br>
📁 Veri akışını yönetmek için LiveData, arayüz durumunun yönetimi için UIState,<br>
🔃 Fragmentlar arası geçiş ve veri göndermek için Jetpack Navigation kullanabilirsin.
<hr>

### Dependencies
<pre>
- Plugin 
 id 'androidx.navigation.safeargs.kotlin'
 id 'dagger.hilt.android.plugin'
 id 'kotlin-kapt'
 
- build.gradle(:app)

def roomVersion = '2.5.1'
def nav_version = "2.5.3"

 //recyclerView
    implementation 'androidx.recyclerview:recyclerview:1.3.0'

    //retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'

    //Gson
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    //okhttp
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.0"
    
    // coroutine
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2"

    //view model and livedata
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
    implementation "androidx.lifecycle:lifecycle-viewmodel:2.6.1"
    
    //room
    implementation "androidx.room:room-runtime:$roomVersion"
    implementation "androidx.legacy:legacy-support-v4:1.0.0"
    kapt "androidx.room:room-compiler:$roomVersion"
    implementation "androidx.room:room-ktx:$roomVersion"
    
    //dagger-hilt
    implementation 'com.google.dagger:hilt-android:2.44'
    kapt 'com.google.dagger:hilt-compiler:2.44'

    //navigation component
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //circle image view
    implementation 'de.hdodenhof:circleimageview:3.1.0'

    //picasso
    implementation 'com.squareup.picasso:picasso:2.71828'
    
- build.gradle(:project)
    def nav_version = "2.5.3"
    classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
</pre>
<hr>

### Kaynaklar
* [Retrofit](https://square.github.io/retrofit/)
* [Dagger-Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
* [Room Database](https://developer.android.com/training/data-storage/room)
* [Coroutine](https://medium.com/android-beginners/mvvm-with-kotlin-coroutines-and-retrofit-example-d3f5f3b09050)
* [LiveData Overview](https://developer.android.com/topic/libraries/architecture/livedata)
* [Picasso](https://square.github.io/picasso/)
* [Fragment & Fragment View lifecycle](https://developer.android.com/guide/fragments/lifecycle)
* [Activity lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)
* [ViewModel and ViewModel lifecycle](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [ViewModel Scoping APIs](https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-apis)
* [Handling Lifecycles with Lifecycle-Aware Components](https://developer.android.com/topic/libraries/architecture/lifecycle)
* [Learn Jetpack Navigation - Codelab](https://developer.android.com/codelabs/android-navigation#0)
<hr>

### UI Tasarımları
![Ekran Görüntüsü (75)](https://github.com/mendess12/mobillium-staj-task4/assets/76566952/6bb4c724-e875-4950-af33-06abe8f89c11) ![untitled](https://github.com/mendess12/mobillium-staj-task4/assets/76566952/741ca2df-3506-4d6d-8e4c-744d5085d168)


