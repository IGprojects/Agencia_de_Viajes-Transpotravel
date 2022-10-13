module Transpotravel.Transpotravel {
    
	requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
	requires java.sql;
	requires javafx.graphics;
	requires java.desktop;
	requires javafx.base;

    opens Transpotravel.Transpotravel to javafx.fxml;
    exports Transpotravel.Transpotravel;
    exports model;
}