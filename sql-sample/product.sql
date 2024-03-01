-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 30, 2024 lúc 02:21 PM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `fashion-shop`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL,
  `material` enum('COTTON','CANVAS','FABRIC','GOLD','SILVER','COPPER','LEATHER','SILK','DENIM','WOOL','POLYESTER','NYLON','LINEN','VELVET','CHIFFON','SPANDEX','LACE','SYNTHETIC','OTHER') DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `type` enum('SHIRTS','PANTS','DRESSES','SHOES','JACKETS','JEWELRY','ACCESSORIES','SWEATERS','JEANS','SHORTS','SKIRTS','BLOUSES','T_SHIRTS','ACTIVEWEAR','SOCKS','SCARVES','SUNGLASSES','WATCHES','HATS_CAPS','BELTS','GLOVES','WALLETS','PERFUMES','MAKEUP_COSMETICS','HAIR_ACCESSORIES','BACKPACKS','FORMAL_WEAR','OTHER') DEFAULT NULL,
  `imagedata_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `material`, `name`, `price`, `type`, `imagedata_id`) VALUES
(2, 'SYNTHETIC', 'Adidas Running Shoes', 1500000.00, 'SHOES', NULL),
(3, 'SYNTHETIC', 'Nike Dri-FIT T-Shirt', 500000.00, 'T_SHIRTS', NULL),
(4, 'LEATHER', 'Calvin Klein Leather Wallet', 800000.00, 'WALLETS', NULL),
(5, 'VELVET', 'Gucci Velvet Scarf', 1200000.00, 'SCARVES', NULL),
(6, 'DENIM', 'Tommy Hilfiger Denim Jeans', 1200000.00, 'JEANS', NULL),
(7, 'LEATHER', 'Louis Vuitton Leather Backpack', 3000000.00, 'BACKPACKS', NULL),
(8, 'LACE', 'Chanel Lace Blouse', 1800000.00, 'BLOUSES', NULL),
(9, 'OTHER', 'Versace Gold Jewelry Set', 2500000.00, 'JEWELRY', NULL),
(10, 'SILK', 'Prada Silk Scarf', 1500000.00, 'SCARVES', NULL),
(11, 'VELVET', 'Fendi Velvet Hat', 800000.00, 'HATS_CAPS', NULL),
(12, 'WOOL', 'Burberry Wool Sweater', 2000000.00, 'SWEATERS', NULL),
(13, 'SPANDEX', 'Puma Active Leggings', 600000.00, 'ACTIVEWEAR', NULL),
(14, 'GOLD', 'Rolex Gold Watch', 8000000.00, 'WATCHES', NULL),
(15, 'CHIFFON', 'Dior Chiffon Dress', 3500000.00, 'DRESSES', NULL),
(16, 'VELVET', 'Givenchy Velvet Gloves', 1200000.00, 'GLOVES', NULL),
(17, 'LEATHER', 'Yves Saint Laurent Leather Belt', 900000.00, 'BELTS', NULL),
(18, 'LINEN', 'Hermès Linen Blouse', 1600000.00, 'BLOUSES', NULL),
(19, 'DENIM', 'Chloe Denim Skirt', 1200000.00, 'SKIRTS', NULL),
(20, 'SILK', 'Jimmy Choo Silk Heels', 3000000.00, 'SHOES', NULL),
(21, 'NYLON', 'Balenciaga Nylon Backpack', 1800000.00, 'BACKPACKS', NULL),
(22, 'OTHER', 'Marc Jacobs Perfume Set', 2500000.00, 'PERFUMES', NULL),
(23, 'OTHER', 'Giorgio Armani Makeup Kit', 1800000.00, 'MAKEUP_COSMETICS', NULL),
(24, 'VELVET', 'Alexander McQueen Velvet Scarf', 900000.00, 'SCARVES', NULL),
(25, 'LEATHER', 'Dolce & Gabbana Leather Formal Shoes', 3500000.00, 'SHOES', NULL),
(26, 'LEATHER', 'Christian Louboutin Red Bottom Heels', 3000000.00, 'SHOES', NULL),
(27, 'CANVAS', 'Vans Canvas Belt', 700000.00, 'BELTS', NULL),
(28, 'LACE', 'Ralph Lauren Lace Dress', 2000000.00, 'DRESSES', NULL),
(29, 'LEATHER', 'Ferragamo Leather Formal Shoes', 3500000.00, 'SHOES', NULL),
(30, 'WOOL', 'Burberry Wool Hat', 800000.00, 'HATS_CAPS', NULL),
(31, 'VELVET', 'Prada Velvet Gloves', 1200000.00, 'GLOVES', NULL),
(32, 'LINEN', 'Chanel Linen Blouse', 1600000.00, 'BLOUSES', NULL),
(33, 'DENIM', 'Yves Saint Laurent Denim Skirt', 1200000.00, 'SKIRTS', NULL),
(34, 'VELVET', 'Louis Vuitton Velvet Scarf', 900000.00, 'SCARVES', NULL),
(35, 'VELVET', 'Gucci Velvet Scarf', 1800000.00, 'SCARVES', NULL);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6d8deakb8jl5h2ola2043itpe` (`imagedata_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `FK6d8deakb8jl5h2ola2043itpe` FOREIGN KEY (`imagedata_id`) REFERENCES `image_data` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
