Nama: Isa Citra Buana
NPM: 2206081465



WEEK01

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