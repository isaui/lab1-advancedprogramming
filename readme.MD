Advanced Programming

Nama: Isa Citra Buana

NPM: 2206081465

Link deployment: https://advancebanget-isacitraorg.koyeb.app

WEEK04 (MODULE 4)

1. TDD Flow sangat bermanfaat untuk continouous development dalam pengembangan software dimana software akan terus berkembang mengikuti permintaan client. TDD Flow memastikan bahwa software tetap memenuhi kualitas meskipun requirement terus berubah.
2. 
- Fast

Saya merasa test yang saya buat sudah cepat sehingga dapat berjalan tanpa mengganggu workflow

- Independent

Saya merasa test yang saya buat sudah independent yang mana artinya setiap test tidak bergantung dengan test lain.

- Repeatable

Test yang dibuat hasilnya harus konsisten di setiap pengujian dengan asumsi tidak terjadi perubahan besar terhadap kode yang menyebabkan hasilnya jadi berbeda di test selanjutnya. Saya yakin bahwa test saya repeatable karena saya sudah setup mock yang sama sehingga hasil test pasti konsisten.

- Self Validating

Test harus jelas dalam menguji apakah fitur berjalan dengan baik atau tidak. Saya yakin bahwa test yang saya buat sudah Self Validating. Itu dibuktikan dengan penggunaan method assertEquals, assertNull, dan lain sebagainya.

- Timely

Test harus mencover semua happy dan unhappy paths dan saya sudah membuat test yang menconver semua happy dan unhappy paths.

WEEK03 (MODULE 3)

1. Saya mengaplikasikan prinsip SOLID, yang terdiri atas:

- Single Responsibility Principle: Setiap kelas punya satu tugas

- Open/Closed Principle: Setiap kelas terbuka untuk di-extends tetapi hindari modifikasi pada kode internal kelas tersebut

- Liskov Substitution Principle: Setiap subclass harus bisa menggantikan superclass, jika tidak maka jangan dijadikan subclass

- Interface Segregation Principle: Client tidak boleh dipaksa mengimplementasi semua member dari interface, oleh karena itu client perlu interface paling minimal atau dengan kata lain, interface harus dibuat modular.

- Dependency Inversion Principle: Hubungan komposisi dan ketergantungan antara high level class dengan low level class harus didasarkan pada abstraksi.

2. 
- SRP: Memberikan setiap kelas tugas yang jelas dan menambah keterbacaan. Misalnya CarController mengatur controller untuk route yang dimulai dengan '/car', sementara ProductController mengatur controller untuk route yang dimulai dengan '/product'

- OCP: Mendorong desain modular. Misalnya saya membuat interface ICarRepository untuk diimplementasikan oleh kelas CarRepository dapat membuat kelas terebut lebih modular karena bergantung pada kontrak (contract-based). Sehingga ketika  kita ingin menambahkan fungsionalitas tambahan pada CarRepository, kita bisa menambahkan implementasi dari interface lain. Dengan bergantung pada kontrak atau abstraksi, pengembangan fungsionalitas pada kelas menjadi lebih mudah dikelola.

- ISP: Kode Lebih fleksibel. Misalnya interface CarService dipecah menjadi interface-interface fungsionalitas kecil seperti CarModificationService, CarCreationService, CarDeletionService, CarRetrievalService sehingga membuat kelas CarServiceImpl atau lainnya dapat lebih fleksibel untuk ingin mengimplementasikan hanya fungsionalitas-fungsionalitas yang sesuai dengan kebutuhan kelas tersebut.

- IDP: Pengurangan ketergantungan langsung. Misalnya pada high level module yaitu CarController, kita memiliki komposisi salah satunya carservice sebagai low level module. CarController tidak boleh bergantung pada implementasi langsung dari carservice, akan tetapi bergantung pada interface-nya itu sendiri. Hal ini  Ini mengurangi ketergantungan langsung dan membuat desain lebih fleksibel.

- LSP: Memastikan inheritance yang tepat. Misalnya CarController tidak seharusnya menjadi subclass dari ProductController. Hal tersebut karena perbedaan job dari CarController dan ProductController. Selain itu, CarController tentu saja tidak bisa mengerjakan job dari ProductController sehingga mempengaruhi kebenaran program menjadi tidak tepat.

3.
- Tanpa menerapkan ISP, interface cenderung menjadi terlalu besar dan terlalu bergantung pada banyak kelas-kelas yang tidak memerlukan semua fungsionalitas yang didefinisikan dalam interface tersebut. Sebagai contoh, jika kita memiliki interface besar seperti CarService yang mencakup semua operasi terkait mobil, kelas-kelas yang hanya memerlukan beberapa operasi tertentu mungkin akan terpaksa mengimplementasikan semua operasi yang ada dalam interface tersebut. Hal ini menghasilkan kelas-kelas yang tidak terkait memiliki ketergantungan yang tidak perlu dan mengakibatkan kode yang tidak efisien dan sulit dipelihara.

- Tanpa menerapkan LSP, pewarisan kelas tidak selalu dapat digunakan secara serupa, yang dapat mengakibatkan kegagalan dalam memenuhi kontrak atau ekspektasi yang diberikan oleh kelas induk. Sebagai contoh, jika CarController adalah sub-kelas dari ProductController, kita akan menemukan bahwa CarController tidak dapat menggantikan ProductController secara sempurna karena tanggung jawab dan perilaku kelas tersebut berbeda. Hal ini dapat menghasilkan sistem yang tidak konsisten dan tidak stabil.

- Tanpa menerapkan DIP, kelas yang lebih tinggi secara langsung terikat pada detail implementasi kelas yang lebih rendah, bukan pada abstraksi atau kontrak yang lebih umum. Sebagai contoh, jika kelas CarController bergantung langsung pada implementasi konkret CarRepository daripada pada antarmuka ICarRepository, itu akan melanggar DIP. Hal ini menyebabkan kelas yang lebih tinggi menjadi kurang fleksibel, sulit diuji, dan sulit dipelihara karena ketergantungan langsung pada detail implementasi yang spesifik. Contoh nyatanya adalah hal tersebut membuat kelas CarController hanya bisa bekerja dengan CarRepository. Padahal bisa jadi kita memiliki alternatif implementasi ICarRepository berdasarkan real case yang ada.

- Tanpa menerapkan SRP, misalnya, CarController tidak hanya mengatur rute untuk endpoint yang dimulai dengan '/car', tetapi juga berusaha untuk mengatur rute untuk berbagai endpoint lainnya dalam aplikasi. Hal ini berarti CarController menjadi terlalu terfokus pada tugas-tugas yang tidak terkait, seperti mengelola endpoint untuk mobil, produk, dll., yang seharusnya dilakukan oleh kelas-kelas kontroler yang berbeda. Akibatnya, kode dalam CarController menjadi rumit dan sulit dipelihara karena harus menangani banyak tanggung jawab yang berbeda. Selain itu, jika terjadi perubahan pada salah satu tanggung jawab, seperti penambahan endpoint baru untuk entitas lain, maka semua perubahan harus dilakukan dalam satu kelas, menyebabkan risiko kesalahan dan mengganggu keseluruhan sistem.

- Tanpa menerapkan OCP, yang dinyatakan dalam contoh tentangketiadaan dari ICarRepository, sistem tidak didesain untuk mendorong desain modular. Ini berarti bahwa ketika Anda ingin menambahkan fungsionalitas tambahan pada CarRepository, kita mungkin cenderung untuk mengubah langsung implementasi yang sudah ada tanpa memperhatikan struktur modular yang baik. Sebagai contoh, kita mungkin akan menambahkan metode baru atau memodifikasi metode yang sudah ada dalam kelas CarRepository tanpa mempertimbangkan pembuatan interface atau kontrak baru untuk menangani fungsionalitas tambahan tersebut. Akibatnya, pengembangan fungsionalitas tambahan pada CarRepository menjadi kurang terstruktur dan sulit dikelola. Ketergantungan yang erat pada implementasi konkret juga membuat perluasan sistem menjadi lebih sulit, karena perubahan yang dilakukan dalam implementasi mungkin memengaruhi bagian-bagian lain dari sistem yang bergantung pada CarRepository. Ini mengakibatkan sistem menjadi lebih rentan terhadap perubahan, kurang fleksibel, dan sulit dipelihara dalam jangka panjang.

WEEK02 (MODULE 2)

1. Code Quality Issue

  a. Komentar yang tidak diperlukan

  Misalnya todo yang sudah dikerjakan atau komentar-komentar lain yang sebenarnya tidak perlu dituliskan karena kodenya sudah jelas itu saya hapus.

  b. Duplikasi Kode

  Untuk mengurangi duplikasi kode, beberapa value yang nilainya sama dimasukkan ke suatu variabel

  c. Logging

  Logging dapat membocorkan informasi yang seharusnya tidak ditampilkan. Oleh karena itu ketika production, logging seperti System.out.println perlu dihapus. Oleh karena itu saya menghapus logging demikian.

  d. Description Issue

  Elemen table pada HTML perlu diperjelas maksudnya, seperti menambahkan aria-label. Saya menambahkan aria-label yaitu "products table" untuk table pada list product agar maksud dari table tersebut dapat dimengerti oleh pengguna

  e. Unnecessary Local Variable

  Terkadang ada beberapa local variable yang tidak diperlukan sehingga saya perlu menghapusnya. Misalnya variabel temporer yang hanya digunakan untuk menyimpan raw value.

2. 
Menurut saya, implementasi workflows yang telah saya lakukan telah memenuhi definisi Continuous Integration (CI) dan Continuous Deployment (CD) dengan baik. Pertama, dengan adanya workflow untuk automation test setiap kali Continuous Integration, saya telah mengintegrasikan praktik pengujian secara otomatis ke dalam alur kerja pengembangan. Ini memastikan bahwa setiap perubahan kode diuji secara otomatis, membantu mendeteksi dan memperbaiki masalah dengan cepat. Kedua, penggunaan Sonarcloud untuk meninjau masalah kualitas kode memberikan jaminan bahwa standar kualitas dipertahankan dalam setiap iterasi pengembangan. Ini sesuai dengan prinsip Continuous Integration yang mendorong untuk mengintegrasikan perubahan kode secara teratur dan memastikan kualitasnya. Ketiga, dengan menyertakan workflow scorecard, saya memberikan transparansi terhadap performa dan keamanan code secara keseluruhan. Keempat, dengan membuat workflow auto deployment, saya sudah menerapkan Continuous Development dengan baik.

WEEK01 (MODULE 1)

Reflection 1

Saya menerapkan clean code diantaranya sebagai berikut:
1. Meaningful Names

Saya memberikan nama variabel, fungsi, dan kelas secara jelas sesuai dengan kegunaan dan sesuai dengan konvensi yang telah ada.

2. Error Handling yang Jelas

Daripada saya pass null, return null, atau melakukan return status code yang tidak jelas, saya lebih memilih menggunakan error handling 
dan menampilkan kesalahan apa yang terjadi pada aplikasi

3. Git Branching

Dengan menggunakan git branching, saya dapat dengan mudah mengorganisir fitur fitur aplikasi

4. Tidak Membuat Komentar Aneh

Jika menuliskan komentar, seperlunya saja untuk menjelaskan kode yang memang perlu dijelaskan.

Saya menerapkan secure code diantaranya sebagai berikut:
belum ada karena projeknya memang masih sederhana

Reflection 2

1. Setelah menulis unit test, saya merasa lebih yakin bahwa kode yang saya tulis sudah baik. Unit test membantu saya memastikan bahwa setiap bagian dari program saya berfungsi sebagaimana yang diharapkan. 

Tidak ada aturan baku tentang berapa banyak unit test yang harus dibuat dalam sebuah kelas. Jumlah unit test yang diperlukan akan bergantung pada kompleksitas dan kebutuhan fungsionalitas dari kelas tersebut. Yang penting, unit test harus mencakup semua kasus penggunaan yang mungkin dan menguji semua fitur dan fungsionalitas dari kelas tersebut.

100% code coverage artinya setiap baris kode dalam program telah dieksekusi setidaknya satu kali selama proses pengujian. Akan tetapi, terkadang akan ada kasus uji yang tidak terpikirkan oleh programmer atau ada bug tersembunyi yang belum ditemukan. Dengan demikian, 100% code coverage tidak menjadi jaminan bahwa program bebas dari bug atau error.

2. Menurut pendapat saya, penambahan functional test suite baru untuk memverifikasi jumlah item dalam daftar produk seharusnya tidak secara signifikan mengurangi kualitas kode, asalkan dilakukan sesuai dengan prinsip-prinsip clean code. Isunya adalah  duplikasi kode. Hal tersebut karena kita menulis ulang beberapa kode yang sebenarnya memiliki tujuan yang sama. Salah satu cara untuk mengatasinya adalah menerapkan modularitas dan  abstraksi yang tepat untuk menghindari duplikasi kode. Misalnya membuat kelas utilitas. Kelas utilitas adalah 
sebuah pendekatan yang berguna untuk menghindari duplikasi kode dan mempromosikan prinsip-prinsip clean code. Kelas utilitas adalah kelas yang berisi serangkaian metode yang dapat digunakan secara luas dalam berbagai bagian dari kode Anda, termasuk dalam functional test suites.
