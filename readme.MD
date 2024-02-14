Advanced Programming
Nama: Isa Citra Buana
NPM: 2206081465

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
