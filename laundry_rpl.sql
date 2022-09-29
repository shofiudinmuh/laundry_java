-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Jan 2022 pada 04.30
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 7.3.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `laundry_rpl`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `paket_laundry`
--

CREATE TABLE `paket_laundry` (
  `kd_paket` char(8) NOT NULL,
  `nama_paket` varchar(30) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `paket_laundry`
--

INSERT INTO `paket_laundry` (`kd_paket`, `nama_paket`, `harga`) VALUES
('PL0001', 'Cuci Kering', 4000),
('PL0002', 'Cuci Setrika', 6000),
('PL0003', 'Express', 8000),
('PL0004', 'Bed Cover 1 (Besar)', 20000),
('PL0005', 'Bed Cover 2 (Sedang)', 15000),
('PL0006', 'Sprey A (Besar)', 15000),
('PL0007', 'Sprey B (Sedang)', 10000),
('PL0008', 'Selimut A (Besar)', 20000),
('PL0009', 'Selimut B (Sedang)', 15000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pelanggan`
--

CREATE TABLE `pelanggan` (
  `id_pelanggan` varchar(8) NOT NULL,
  `nama_pelanggan` varchar(30) DEFAULT NULL,
  `gender` char(1) NOT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `no_hp` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pelanggan`
--

INSERT INTO `pelanggan` (`id_pelanggan`, `nama_pelanggan`, `gender`, `alamat`, `no_hp`) VALUES
('CS0001', 'Muhammad Shofiudin', 'L', 'Blora', '082329373593'),
('CS0002', 'Amirul Chakim', 'L', 'Surabaya', '0812347890'),
('CS0003', 'Arifatun Nikmat Rahmatika', 'P', 'NTB', '085337606196'),
('CS0004', 'Almaratus Sholekah', 'L', '', '082325627380'),
('CS0005', 'Salsabilla Annafi\'u Nur\'aini', 'P', 'Surabaya', ''),
('CS0006', 'Ali', 'L', 'Tempurejo', '085123455678'),
('CS0007', 'Ahmad', 'L', 'Ngampel', '021823758089'),
('CS0009', 'Jono', 'L', 'Surabaya', '0812356789');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaran`
--

CREATE TABLE `pengeluaran` (
  `tgl` date NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `jumlah` smallint(6) NOT NULL,
  `harga` int(11) NOT NULL,
  `total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pengeluaran`
--

INSERT INTO `pengeluaran` (`tgl`, `nama_barang`, `jumlah`, `harga`, `total`) VALUES
('2022-01-02', 'Pewangi', 5, 5000, 50000),
('2022-01-02', 'Detergen', 12, 17500, 210000),
('2022-01-04', 'Pewangi', 10, 15000, 180000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `waktu` date NOT NULL,
  `jam` timestamp NOT NULL DEFAULT current_timestamp(),
  `kd_transaksi` varchar(8) NOT NULL,
  `id_pelanggan` varchar(8) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `paket` varchar(30) NOT NULL,
  `harga` int(11) NOT NULL,
  `berat` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `status` varchar(20) NOT NULL,
  `pembayaran` varchar(25) NOT NULL DEFAULT 'Belum bayar',
  `bayar` int(11) DEFAULT NULL,
  `kembalian` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`waktu`, `jam`, `kd_transaksi`, `id_pelanggan`, `nama`, `paket`, `harga`, `berat`, `total`, `status`, `pembayaran`, `bayar`, `kembalian`) VALUES
('2021-12-19', '2022-01-04 09:48:14', 'TR0001', 'CS0001', '', 'Reguler', 4000, 5, 20000, 'Selesai', 'Lunas', 0, 0),
('2021-12-19', '2022-01-04 09:48:14', 'TR0002', 'CS0001', '', 'Reguler', 3000, 2, 6000, 'Selesai', 'Lunas', 0, 0),
('2021-12-19', '2022-01-04 09:48:14', 'TR0003', '', '', 'Agak Cepat', 5000, 5, 25000, 'Selesai', 'Lunas', 0, 0),
('2022-01-03', '2022-01-04 09:55:56', 'TR0004', 'CS0003', 'Arifatun Nikmat Rahmatika', 'Agak Cepat', 5000, 4, 20000, 'Selesai', 'Lunas', 20000, 0),
('2022-01-03', '2022-01-04 09:55:56', 'TR0005', 'CS0004', 'Almaratus Sholekah', 'Cepat', 7500, 5, 37500, 'Selesai', 'Lunas', 40000, 2500),
('2022-01-04', '2022-01-03 19:37:29', 'TR0006', 'CS0006', 'Ali', 'Agak Cepat', 5000, 4, 20000, 'Selesai', 'Lunas', 20000, 0),
('2022-01-04', '2022-01-03 19:38:05', 'TR0007', 'CS0001', 'Muhammad Shofiudin', 'Cepat', 7500, 5, 37500, 'Selesai', 'Lunas', 40000, 2500),
('2022-01-04', '2022-01-03 19:38:25', 'TR0008', 'CS0002', 'Amirul Chakim', 'Agak Cepat', 5000, 5, 25000, 'Selesai', 'Lunas', 30000, 5000),
('2022-01-04', '2022-01-04 01:16:36', 'TR0009', '', '', 'Agak Cepat', 5000, 4, 20000, 'Selesai', 'Lunas', 20000, 0),
('2022-01-07', '2022-01-04 01:17:58', 'TR0011', 'CS0006', 'Ali', 'Cepat', 7500, 4, 30000, 'Selesai', 'Lunas', 30000, 0),
('2022-01-04', '2022-01-04 04:23:23', 'TR0012', 'CS0007', 'Ahmad', 'Agak Cepat', 5000, 5, 25000, 'Selesai', 'Lunas', 30000, 5000),
('2022-01-07', '2022-01-04 04:44:33', 'TR0014', 'CS0006', 'Ali', 'Cepat', 7500, 5, 37500, 'Selesai', 'Lunas', 40000, 2500),
('2022-01-07', '2022-01-04 07:07:18', 'TR0016', 'CS0007', 'Ahmad', 'Agak Cepat', 5000, 3, 15000, 'Selesai', 'Lunas', 15000, 0),
('2022-01-07', '2022-01-07 02:40:34', 'TR0017', 'CS0009', 'Jono', 'Sprey A (Besar)', 15000, 3, 45000, 'Selesai', 'Lunas', 50000, 5000),
('2022-01-07', '2022-01-07 02:53:45', 'TR0018', 'CS0006', 'Ali', 'Express', 8000, 5, 40000, 'Menunggu', 'Belum bayar', NULL, NULL);

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `nama` varchar(20) NOT NULL,
  `gender` char(1) NOT NULL,
  `email` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `telepon` varchar(30) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `akses` varchar(20) NOT NULL DEFAULT 'Admin'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`nama`, `gender`, `email`, `alamat`, `telepon`, `username`, `password`, `akses`) VALUES
('Shofi', 'L', '', '', '', 'Shfdien', 'Shfdien0', 'Admin'),
('Muhammad Shofiudin', 'L', 'shofiudinmuh@gmail.com', 'Bogorejo, Blora', '082329373593', 'shofiudinmuh', 'Shfdien08', 'Owner');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `paket_laundry`
--
ALTER TABLE `paket_laundry`
  ADD PRIMARY KEY (`kd_paket`);

--
-- Indeks untuk tabel `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_pelanggan`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`kd_transaksi`);

--
-- Indeks untuk tabel `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
