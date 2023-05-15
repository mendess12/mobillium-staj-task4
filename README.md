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
 
- build.gradle(:app)
 //recyclerView
    implementation 'androidx.recyclerview:recyclerview:1.3.0'

    //retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'

    //Gson
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    //okhttp
    implementation "com.squareup.okhttp3:logging-interceptor:4.9.0"

    //view model and livedata
    implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
    implementation "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
    implementation "androidx.lifecycle:lifecycle-viewmodel:2.6.1"

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
</pre>
<hr>

### Kaynaklar
* [Retrofit](https://square.github.io/retrofit/)
* [LiveData Overview](https://developer.android.com/topic/libraries/architecture/livedata)
* [Picasso](https://square.github.io/picasso/)
* [Fragment & Fragment View lifecycle]()
* [Activity lifecycle](https://developer.android.com/guide/fragments/lifecycle)
* [ViewModel and ViewModel lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)
* [ViewModel Scoping APIs](https://developer.android.com/topic/libraries/architecture/viewmodel)
* [Handling Lifecycles with Lifecycle-Aware Components](https://developer.android.com/topic/libraries/architecture/viewmodel/viewmodel-apis)
* [Learn Jetpack Navigation - Codelab](https://developer.android.com/codelabs/android-navigation#0)
<hr>

### UI Tasarımları


