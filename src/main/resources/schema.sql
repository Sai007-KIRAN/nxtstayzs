-- Create the hotel table
CREATE TABLE if not exists hotel (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(255),
    location varchar(255),
    rating INT
);

-- Create the room table
CREATE TABLE if not exists room (
    id INT PRIMARY KEY AUTO_INCREMENT,
    roomNumber varchar(255),
    type varchar(255),
    price DOUBLE,
    hotelId INT,
    FOREIGN KEY (hotelId) REFERENCES hotel(id)
);