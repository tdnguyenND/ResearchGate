drop database researchGate;
create database researchGate;
use researchGate;
create table Student (
                         first_name varchar(20) not null,
                         last_name varchar(20) not null,
                         user_id int not null,
                         address varchar(100) not null,
                         date_of_birth date not null,
                         gender varchar(10) not null,
                         phone_number varchar(50) not null,
                         email varchar(50) not null,
                         academic_level varchar (50) not null,
                         training_place varchar(100) ,
                         achievement varchar(100) ,
                         forte varchar(100) ,
                         hobbits varchar(100) ,
                         primary key(user_id)
);
/*Data for table Student */
insert into Student (first_name,last_name,user_id,address,date_of_birth,gender,phone_number,email,academic_level,training_place,achievement,forte,hobbits) values
('Đặng','Huy','18020313','261 Nguyễn Ngọc Vũ','2000-09-29','nam','0969936543','18020313@vnu.edu.vn','university','88 Phạm Văn Đồng',NULL,'Có Quy Tắc','Nghe nhạc'),
('Quang','Bình','18020217','26 Lê Thanh Nghị','2000-06-15','nam','0972282969','18020217@vnu.edu.vn','university','1 Trần Quốc Toản','Toeic 650','Kỹ năng làm việc nhóm','Chơi game'),
('Văn','Huy','18022317','1 Phạm Văn Đồng','2000-05-30','nam','0969652714','18022317@vnu.edu.vn','university',NULL,NULL,'Linh Hoạt','Chơi game'),
('Trường','Vũ','18020056','681 Phạm Tuấn Tài','2000-12-18','nam','0123656732','18020056@vnu.edu.vn','university','26 Hồ Tùng Mậuu','Ielts 6.5',null,'Đá bóng'),
('Thị','Dịu','18020213','KTX Mễ Trì','2000-09-26','nữ','0972906833','18020213@vnu.edu.vn','university',NULL,NULL,'Nhanh nhẹn','Hát'),
('Văn','Mạnh','18020001','19 Lương Thế Vinh','2000-02-26','nam','0969888732','18020001@vnu.edu.vn','university',NULL,NULL,NULL,'Xem phim'),
('Huy','Đông','18020101','1952 Láng','2000-10-20','nam','0972787634','18020101@vnu.edu.vn','university','291 Cầu Giấy',NULL,'Giao tiếp tốt','Nghe nhạc'),
('Quang','Minh','18020399','110 Trần Duy Hưng','2000-03-09','nam','0969503965','18020399@vnu.edu.vn','university',NULL,NULL,'Chăm chỉ','Đá bóng'),
('Thu','Trang','18021234','43 Tam Trinh','2000-01-10','nữ','0972059690','18021234@vnu.edu.vn','university','68 Trần Phú',NULL,NULL,'Du lịch'),
('Thu','Hằng','18020952','406 Thái Hà','2000-11-15','nữ','0123638744','18020952@vnu.edu.vn','university',NULL,NULL,'Hòa đồng','Mua sắm')
;

create table Account(
                        user_id int not null auto_increment,
                        username varchar(20) not null ,
                        password varchar(20) not null,
                        role varchar(20) not null,
                        primary key(user_id)
);
/* Data for table Account*/
insert into Account(username,password,role) values
('HuyDang','huy18020313','student'),
('QuangBinh','binh6969hn','company'),
('VanHuy','huy6886TB','student'),
('TruongVu','vu7777TB','student'),
('ThiDiu','diuvu213TB','student'),
('VanManh','manh1234HN','student'),
('HuyDong','dong0101BG','student'),
('QuangMinh','quangminh68BG','student'),
('ThuTrang','trang1234ND','student'),
('ThuHang','Hang0952HD','student')
;
create table ProgrammingLanguage(
                                    user_id int not null,
                                    programming_language varchar(50) not null
);
/*Data for table ProgrammingLanguages
	C 01
    C++ 02
    Java 03
    Js 04
    Ruby 05
    php 06
    C# 07
    Python 08
    TypeScript 09
    Shell 10
*/
insert into ProgrammingLanguage (user_id,programming_language) values
('18020313','C'),
('18020217','Ruby'),
('18022317','PHP'),
('18020056','Java'),
('18020213','C++'),
('18020001','JavaScript'),
('18020101','Shell'),
('18020399','C#'),
('18021234','TypeScript'),
('18020952','Python')
;
create table Company(
                        name_company varchar(50) not null,
                        user_id int not null auto_increment,
                        address varchar(100) not null,
                        hotlines varchar(50) not null,
                        email varchar(50) not null,
                        primary key(user_id)
);
/* Data for table Company */
insert into Company(name_company,address,hotlines,email) values
('CÔNG TY TNHH DEVMOBA ','Tố Hữu - La Khê - Hà Đông - Hà Nội','19005188','devmobatuyendung@gmail.com.vn'),
('Công ty TNHH Thương Mại Và Dịch Vụ Tường Đan ','Khu Đô Thị Mới Đại Kim, Phường Đại Kim , Quận Hoàng Mai , Hà Nội','19007227','tuongdantuyendung@gmail.com.vn'),
('Công TY TNHH BuCA - Hà Nội','Nguyễn Phong Sắc, Cầu Giấy ,Hà Nội','19005777','bucatuyendung@gmail.com.vn')
;