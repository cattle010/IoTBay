-----------------------------------------------------------------------------------------------

/*
41025 - Introduction to Software Development - Assignment 2

Create database objects for IoTBay Assignment
*/

-- DROP TABLES UPON TABLE CREATION TO PREVENT ISSUES WITH DATA INSERTION
 
ALTER TABLE ACCESSLOG_T DROP CONSTRAINT ACCESSLOG_FK;
ALTER TABLE ORDER_T DROP CONSTRAINT ORDER_FK1;
ALTER TABLE ORDER_T DROP CONSTRAINT ORDER_FK2;
ALTER TABLE ORDER_T DROP CONSTRAINT ORDER_FK3;
ALTER TABLE ORDERLINEITEM_T DROP CONSTRAINT ORDERLINEITEM_FK1;
ALTER TABLE ORDERLINEITEM_T DROP CONSTRAINT ORDERLINEITEM_FK2;
DROP TABLE USER_T;
DROP TABLE ACCESSLOG_T;
DROP TABLE PAYMENT_T;
DROP TABLE SHIPPINGADDRESS_T;
DROP TABLE PRODUCT_T;
DROP TABLE ORDER_T;
DROP TABLE ORDERLINEITEM_T;


CREATE TABLE USER_T (
    UserID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,  INCREMENT BY 1),
    UserEmail VARCHAR(100) NOT NULL,
    UserFirstName VARCHAR(50) NOT NULL,
    UserLastName VARCHAR(50) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    PhoneNumber VARCHAR(15),
    IsStaffUser BOOLEAN,
    IsRegisteredUser BOOLEAN,
    CONSTRAINT USER_PK PRIMARY KEY (UserID)
);

CREATE TABLE ACCESSLOG_T (
    AccessLogID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,  INCREMENT BY 1),
    UserID INTEGER NOT NULL,
    UserLoginTime TIMESTAMP NOT NULL,
    UserLogoutTime TIMESTAMP NOT NULL,
    CONSTRAINT ACCESSLOG_PK PRIMARY KEY (AccessLogID),
    CONSTRAINT ACCESSLOG_FK FOREIGN KEY (UserID) REFERENCES USER_T(UserID)
);

CREATE TABLE PAYMENT_T (
    PaymentID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,  INCREMENT BY 1),
    PaymentName VARCHAR(50) NOT NULL,
    PaymentStatus VARCHAR(20) NOT NULL,
    PaymentAmount DECIMAL(6, 2) NOT NULL,
    PaymentDate TIMESTAMP NOT NULL,
    CONSTRAINT PAYMENT_PK PRIMARY KEY (PaymentID)
);

CREATE TABLE SHIPPINGADDRESS_T (
    ShippingAddressID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,  INCREMENT BY 1),
    StreetNumber VARCHAR(20) NOT NULL,
    StreetName VARCHAR(100) NOT NULL,
    City VARCHAR(60) NOT NULL,
    State VARCHAR(60) NOT NULL,
    Postcode INTEGER NOT NULL,
    Country VARCHAR(50) NOT NULL,
    CONSTRAINT SHIPPINGADDRESS_PK PRIMARY KEY (ShippingAddressID)
);

CREATE TABLE PRODUCT_T (
    ProductID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,  INCREMENT BY 1),
    ProductName VARCHAR(50) NOT NULL,
    BrandName VARCHAR(50) NOT NULL,
    Description VARCHAR (10000) NOT NULL,
    CostPerUnit DECIMAL(6, 2) NOT NULL,
    Stock INTEGER NOT NULL,
    CONSTRAINT PRODUCT_PK PRIMARY KEY (ProductID)
);

CREATE TABLE ORDER_T (
    OrderID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,  INCREMENT BY 1),
    UserID INTEGER NOT NULL,
    PaymentID INTEGER NOT NULL,
    ShippingAddressID INTEGER NOT NULL,
    OrderDate TIMESTAMP NOT NULL,
    ShipDate TIMESTAMP,
    OrderStatus VARCHAR(50) NOT NULL,
    CONSTRAINT ORDER_PK PRIMARY KEY (OrderID),
    CONSTRAINT ORDER_FK1 FOREIGN KEY (UserID) REFERENCES USER_T(UserID),
    CONSTRAINT ORDER_FK2 FOREIGN KEY (PaymentID) REFERENCES PAYMENT_T(PaymentID),
    CONSTRAINT ORDER_FK3 FOREIGN KEY (ShippingAddressID) REFERENCES SHIPPINGADDRESS_T(ShippingAddressID)
);

CREATE TABLE ORDERLINEITEM_T (
    OrderID INTEGER NOT NULL,
    ProductID INTEGER NOT NULL,
    Quantity INTEGER NOT NULL,
    CONSTRAINT ORDERLINEITEM_PK PRIMARY KEY (OrderID, ProductID),
    CONSTRAINT ORDERLINEITEM_FK1 FOREIGN KEY (OrderID) REFERENCES ORDER_T(OrderID),
    CONSTRAINT ORDERLINEITEM_FK2 FOREIGN KEY (ProductID) REFERENCES PRODUCT_T(ProductID)
);

-----------------------------------------------------------------------------------------------

/*
Insert mock data into the datebase to enable functionality
*/

-- USER_T Entries
INSERT INTO USER_T(UserEmail, UserFirstName, UserLastName, Password, PhoneNumber, IsStaffUser, IsRegisteredUser) VALUES
('superadmin@iotbay.com', 'Super', 'Admin', 'dc%ham0XVHWoG$vl39mqNh3DCg', '0404 040 404', TRUE, FALSE),
('john_smith@iotbay.com', 'John', 'Smith', 'EEhR0do92U%bo9te1Z4^eF35ep', '0404 404 404', TRUE, FALSE),
('tiffanyblack@iotbay.com', 'Tiffany', 'Black', '#8QW$q7DqcMqeks$FKfE#14tcU', '0404 090 404', TRUE, FALSE),
('ceripollard@iotbay.com', 'Ceri', 'Pollard', 'Mo7FJudziFNd6*29%crgTw&cfs', '0404 030 404', TRUE, FALSE),
('le0little@gmail.com', 'Leonard', 'Little', 'kkEF3lt0!AFN84o&%Kq8P^smh@', '0400 010 124', FALSE, TRUE),
('eplummer66@yahoo.com', 'Elissa', 'Plummer', '$zfxnpxRNUStMcdwX!ZlpI4%9E', '0412 043 674', FALSE, FALSE),
('kredman8@outlook.com', 'Keanu', 'Redman', 'V&Q^s@qxY!*K17&%l3Kn58c3pt', NULL, FALSE, FALSE),
('m.peacock@gmail.com', 'Mohammed', 'Peacock', 'nwAHwmJL8zthIx$c85VO8$As!0', '0404 074 323', FALSE, TRUE),
('kerry_ryan123@live.com', 'Kerry', 'Rogers', '2F1MUQDi#f7aI^V6A*mn%m5A2W', '0404 086 357', FALSE, TRUE),
('s_turnbull99@gmail.com', 'Selina', 'Turnbull', 'DszN!7#e&LVE4l8HLMb&ca^CRg', '0404 531 054', FALSE, FALSE),
('c_roman@outlook.com', 'Coral', 'Roman', 'opfT0u9wBg0$##FgIGZ^^vO$vo', NULL, FALSE, TRUE),
('j.mac12gmail.com', 'Jolie', 'Mcfarland', 'ZzDlK##96bS1A2uQc&ZlrOZ5s7', '0404 784 865', FALSE, FALSE);

-- ACCESSLOG_T Entries
INSERT INTO ACCESSLOG_T(UserID, UserLoginTime, UserLogoutTime) VALUES 
(1, '2020-05-12 10:52:12', '2020-05-12 11:23:23'),
(1, '2020-05-12 10:54:32', '2020-05-12 12:11:32'),
(2, '2020-05-12 11:42:39', '2020-05-12 12:32:10'),
(3, '2020-05-12 18:23:43', '2020-05-12 18:40:00'),
(5, '2020-05-13 13:30:32', '2020-05-13 16:54:43'),
(10, '2020-05-13 15:32:01', '2020-05-13 16:33:00'),
(3, '2020-05-13 20:01:59', '2020-05-13 23:54:32'),
(1, '2020-05-14 09:28:09', '2020-05-14 10:45:34'),
(7, '2020-05-14 10:13:17', '2020-05-14 10:15:53'),
(8, '2020-05-15 11:14:38', '2020-05-15 11:50:21'),
(9, '2020-05-15 12:43:11', '2020-05-15 13:21:40'),
(4, '2020-05-16 08:45:00', '2020-05-16 11:51:21'),
(3, '2020-05-16 10:23:43', '2020-05-16 10:30:43'),
(2, '2020-05-17 11:54:31', '2020-05-17 12:56:12'),
(5, '2020-05-17 12:00:55', '2020-05-17 12:10:43'),
(6, '2020-05-18 07:59:12', '2020-05-18 11:48:00'),
(2, '2020-05-18 10:45:18', '2020-05-18 11:45:00'),
(4, '2020-05-18 12:44:13', '2020-05-18 20:43:00'),
(11, '2020-05-18 13:23:56', '2020-05-18 14:00:32'),
(12, '2020-05-18 15:23:10', '2020-05-18 17:38:11'),
(11, '2020-05-18 19:41:50', '2020-05-18 22:56:43'),
(1, '2020-05-18 20:30:23', '2020-05-18 20:45:34');

-- PAYMENT_T Entries
INSERT INTO PAYMENT_T(PaymentName, PaymentStatus, PaymentAmount, PaymentDate) VALUES 
('PayPal', 'Paid', 0142.12, '2020-05-02 15:43:12'),
('Credit Card', 'Paid', 1247.00, '2020-05-03 12:32:44'),
('Debit Card', 'Unpaid', 5321.00, '2020-05-06 18:37:53'),
('PayPal', 'Paid', 0042.52, '2020-05-07 11:53:42'),
('Credit Card', 'Unpaid', 0020.00, '2020-05-08 23:53:36'),
('Credit Card', 'Unpaid', 1074.97, '2020-05-09 10:52:56'),
('Debit Card', 'Paid', 8753.00, '2020-05-10 21:59:33'),
('PayPal', 'Paid', 0106.62, '2020-05-13 15:31:43'),
('PayPal', 'Paid', 0652.12, '2020-05-15 20:40:32'),
('Credit Card', 'Unpaid', 1538.53, '2020-05-17 12:42:32');

-- SHIPPINGADDRESS_T Entries
INSERT INTO SHIPPINGADDRESS_T(StreetNumber, StreetName, City, State, Postcode, Country) VALUES
('45', 'Smith Street', 'Parramatta', 'NSW', 2150, 'Australia'),
('17B', 'Angleton Road', 'Waterloo', 'NSW', 2017, 'Australia'),
('18', 'Thomas Street', 'Mascot', 'NSW', 2020, 'Australia'),
('10', 'Anderson Avenue', 'Sydney', 'NSW', 2000, 'Australia'),
('910B', 'Dora Street', 'Parramatta', 'NSW', 2150, 'Australia'),
('438', 'Jameson Road', 'Engadine', 'NSW', 2233, 'Australia'),
('310', 'Hamilton Street', 'Chatswood', 'NSW', 2067, 'Australia'),
('4A', 'Brandon Road', 'Hurstville', 'NSW', 2220, 'Australia'),
('32', 'Cornelia Crescent', 'Hornsby', 'NSW', 2077, 'Australia'),
('18', 'Smitherson Street', 'Lane Cove', 'NSW', 2066, 'Australia');

-- PRODUCT_T Entries
INSERT INTO PRODUCT_T(ProductName, BrandName, Description, CostPerUnit, Quantity) VALUES 
('Raspberry Pi 4 Model B 2GB', 'Raspberry Pi', 'Raspberry Pi 4 is a huge leap forward for single-board computing, it''s now a true PC replacement for a wide range of uses at home, in school projects and inside commercial products. This new-found performance is powered by a significant increase in the processor, multimedia and I/O technology.', 0074.50, 100),
('Raspberry Pi 4 Model B 4GB', 'Raspberry Pi', 'Raspberry Pi 4 is a huge leap forward for single-board computing, it''s now a true PC replacement for a wide range of uses at home, in school projects and inside commercial products. This new-found performance is powered by a significant increase in the processor, multimedia and I/O technology.', 0102.00, 100),
('Raspberry Pi 3 Model B+', 'Raspberry Pi', 'The Raspberry Pi 3 Model B+ (note the plus on the end) is the latest generation board released by the Raspberry Pi Foundation on 14 March 2018. It has a 1.4Ghz Quad-Core Processor, WiFi, Bluetooth, HDMI, USB along with much more. Oh, and it''s about the size of a credit card!', 0059.50, 100),
('Arduino Starter Kit (Official)', 'Arduino', 'Directly from the people behind what is, undoubtedly, the most popular microcontroller in the world, this kit is absolutely packed with top-notch educational content and hardware. The included 170 page guide book goes above and beyond when walking you through the basics of using electronics with an Arduino. The kit provokes critical thinking the best way you can, with hands on learning. Starting off on the basics of electricity and moving right through to making a universal remote for the home, you''re guaranteed to learn a bunch of awesome stuff. You''ll learn it all by creating 15 different and extremely creative projects that build upon each other.', 0181.50, 50),
('Arduino Uno R3', 'Arduino', 'The Arduino Uno is an 8-bit microcontroller board based on the ATmega328 chip (see the datasheet). It has 14 digital input/output pins (6 of these can also utilize the ADC onboard for PWM), 6 analog inputs, a 16 MHz ceramic resonator, a USB Type-B connector, a DC Barrel jack for power, an ICSP header and a reset button on board! It contains everything needed to support the microcontroller; all you’ll need to do to get started is simply connect it to a computer with a USB cable or power it with a wall wart adapter and the barrel jack or with a battery and the Vin pins.', 0043.95, 150),
('Arduino Mega 2560 R3', 'Arduino', 'The Arduino Mega 2560 is an update on the older Mega board and provides a 54 digital perfect for larger projects. If you''ve worked with the Arduino Uno, or other smaller Arduino boards, then you''ll love the Mega 2560. It retains the Uno''s shield compatibility so you can use all of your existing hardware, and the extra pins have been added to the end of the board. With the extra pins comes a bump in hardware peripherals such as UART, TWI (I2C), SPI and PWM. The Mega 2560 has an Atmel Atmega2560 microcontroller which packs 8x the amount of Flash memory (256KB), and 4x the SRAM and EEPROM (8KB and 4KB respectively). Whilst the extra hardware and connectivity is a great option, keep in mind that the mega2560 still runs at the same clock speed as the mega328 chip found on the Uno.', 0076.95, 200),
('Pycom LoPy4 (LoRaWAN)', 'Pycom', 'The LoPy4 is a compact quadruple network MicroPython enabled development board (LoRa, Sigfox, WiFi, Bluetooth). It’s the perfect enterprise-grade IoT platform for your connected Things. With the latest Espressif ESP32 chipset the LoPy4 offers a perfect combination of power, friendliness, and flexibility. Create and connect your things everywhere. Fast. The LoPy4 can act as a LoRa nano gateway and a multi-bearer (LoRa, Sigfox, WiFi and BLE) development platform suitable for all LoRa and Sigfox networks around the globe. It is programmable with MicroPython and the Pymakr plugins for fast IoT application development, easy programming in-field and extra resilience with network failover. You can also configure the LoPy4 in raw LoRa mode to send packets directly between LoPy4’s. The best blend of speed to deployment and access to new LPWAN networks rolling out across Europe, USA, Africa and India. The LoPy4 is CE, FCC approved, LoRaWAN and Sigfox certified.', 0059.95, 60),
('Pycom Expansion Board 3.1', 'Pycom', 'Introducing the Expansion Board 3.1, compatible with the WiPy, LoPy, LoPy4, SiPy, FiPy and GPy.', 0039.95, 30),
('Pycom GPy', 'Pycom', 'With WiFi, BLE and cellular LTE CAT M1/NB1, the GPy is the latest Pycom triple-bearer MicroPython enabled microcontroller on the market today the perfect enterprise-grade IoT platform for your connected Things. Create and connect your things everywhere, fast. Get on with a board that gets you into the newly available LTE CAT M1 / NB1 networks. The GPy gives you full flexibility during testing, install, deployment and is delivered RCM, IC, CE and FCC certified.', 0099.95, 100),
('Pycom FiPy', 'Pycom', 'Imagine 5 networks in one perfectly-formed, same-small-foot-print-as-WiPy- LoPy-and SiPy, IoT development board. MicroPython enabled. Featuring WiFi, Bluetooth, LoRa, Sigfox and dual LTE-M (CAT M1 and NBIoT) the FiPy gives access to all the world’s LPWAN networks on one tiny board. NOTE: The LTE Antenna MUST always be used with LTE CAT M1 / NB1, or it could cause serious damage to the development board. Get on with a board that gives you full flexibility during testing, install, deployment and even later when you want to switch real-time your airtime network provider. You can switch when the time is right for you or set some parameters that will do so automatically.', 0135.00, 100),
('Sphero SPRK+ Edition - Power Pack', 'Sphero', 'The Sphero SPRK+ educator pack just got even better with the Sphero charging case which allows you to take the power of Sphero with you, anywhere you go, ready for the day''s challenges. The Sphero SPRK+ Edition - Power Pack is ideal for educators, demonstrators, maker spaces, and robotics clubs. It''s the easiest way to get started with Sphero in a group setting and contains everything you need to explore the fun of robotics, coding, and technology! Note: The Power Pack is only available as a complete kit with 12x included SPRK+ robots', 3095.00, 10),
('Hakko FX-888D Digital Soldering Station', 'Hakko', 'The Hakko FX-888D is our go to recommendation for a high-quality soldering iron that has all the features and specs you''d normally find in a much more expensive iron. The FX-888D is incredibly easy to use with a digital readout and interface requiring only two buttons for usage. With this, you can set the temperature, create up to 5 presets for different solder profiles, and set a password to avoid accidental setting changes. The FX-888D is compatible with T18 series tips and has a 30% increase in heater output compared to the standard Hakko 936/937.', 0195.95, 100),
('littleBits Workshop Set', 'LittleBits', 'This is the 2018 edition of the Workshop Set from littleBits. The Workshop Set is a massive collection of littleBits modules that is fit for a whole class (or workshop) full of young learners. In addition to the 160 littleBits Modules and ~180 littleBits accessories, the Workshop Set is loaded educational value. The comprehensive ''Getting Started With littleBits'' Workshop guide (Preview here) is the perfect way to introduce young learners to littleBits in a fun, educational and simple enough way. Each bit and accessory is covered as well as some basic circuits that show students the way things work (like bit order and polarity). This Set is a great pickup for any school/classroom/makerspace looking to introduce littleBits for their STEM education program. LittleBits educates in a ''learning by doing'' way that every student can appreciate and be inspired by. Once you''ve covered the basics using the included educational guide, you can utilise the littleBits learning cycle in order to drive successful workshops/classes with littleBits. You and your students will spend the majority of lessons trying new things, iterating through new concepts and designs and using one of the most trusted and reliable STEM technologies to do so. A great part about littleBits is that they have an entire online learning and sharing platform that''s safe for students to use! And finally, when it comes to packing down and putting it all away, the Workshop set comes with the substantial carry case, that''s just the right size to pack it all up into! If you''ve got any questions about the Workshop Set, littleBits, or anything STEM education related, get in touch with us. We''re here to help.', 3599.00, 20),
('Circuit Playground Express', 'Adafruit', 'Circuit Playground Express is the next step towards a perfect introduction to electronics and programming. Adafruit have taken the original Circuit Playground Classic and made it even better! Not only did Adafruit pack even more sensors in, They also made it even easier to program. You can now start your journey with Microsoft MakeCode block-based or Javascript programming. Then, you can use the same board to try CircuitPython, with the Python interpreter running right on the Express. As you progress, you can advance to using Arduino IDE, which has full support of all the hardware down to the low level, so you can make powerful projects. We have lots of tutorials for both MakeCode and CircuitPython for the Circuit Playground Express! Because you can program the same board in 3 different ways - the Express has great value and re-usability. From beginners to experts, Circuit Playground Express has something for everyone. If you are looking for Adafruit''s original, Arduino-only Circuit Playground, check out the Circuit Playground Classic. The board is round and has alligator-clip pads around it so you don''t have to solder or sew to make it work. You can power it from USB, a AA battery pack, or with a Lipoly battery (for advanced users). Circuit Playground Express has built-in USB support. Built-in USB means you plug it in to program it and it just shows up, no special cable or adapter required. Just program your code into the board then take it on the go!', 0047.47, 1000),
('littleBits Servo - Cross Axle', 'LittleBits', 'The servo Bit is something that we''re really excited about – a controllable motor that can swing back and forth! It has two modes: in “Turn” mode, the input from other littleBits determines the position of the arm – try using a dimmer to set the angle you want. In “Swing” mode, the servo will move back and forth on its own – the input controls how fast it goes. Attach a flag to the arm to make a signaling machine! Check out littleBits Tips + Tricks for more ideas on using the servo!', 0049.96, 1000);

-- ORDER_T Entries
INSERT INTO ORDER_T(UserID, PaymentID, ShippingAddressID, OrderDate, ShipDate, OrderStatus) VALUES 
(5, 1, 1, '2020-05-02 15:43:12', '2020-05-03 16:21:10', 'Shipped'),
(8, 2, 6, '2020-05-03 12:32:44', '2020-05-04 13:53:21', 'Shipped'),
(12, 3, 2, '2020-05-06 18:37:53', NULL, 'Awaiting Payment'),
(11, 4, 3, '2020-05-07 11:53:42', '2020-05-09 09:44:12', 'Shipped'),
(7, 5, 5, '2020-05-08 23:53:36', NULL, 'Awaiting Payment'),
(8, 6, 6, '2020-05-09 10:52:56', NULL, 'Awaiting Payment'),
(10, 7, 4, '2020-05-10 21:59:33', '2020-05-14 10:24:32', 'Shipped'),
(9, 8, 7, '2020-05-13 15:31:43', '2020-05-14 10:25:54', 'Shipped'),
(6, 9, 8, '2020-05-15 20:40:32', '2020-05-16 13:20:43', 'Shipped'),
(5, 10, 1, '2020-05-17 12:42:32', NULL, 'Awaiting Payment');

-- ORDERLINEITEM_T Entries
INSERT INTO ORDERLINEITEM_T VALUES 
(1, 4, 1),
(2, 3, 2),
(3, 7, 5),
(4, 8, 4),
(5, 2, 3),
(5, 4, 1),
(6, 7, 2),
(7, 8, 5),
(7, 3, 2),
(8, 1, 2),
(8, 12, 2),
(9, 5, 2),
(10, 15, 2),
(10, 14, 1),
(10, 13, 1);
