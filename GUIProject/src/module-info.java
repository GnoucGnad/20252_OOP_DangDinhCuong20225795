/**
 * Module GUIProject - Lab 05: GUI Programming & Exception Handling
 */
module GUIProject {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;

	// Mở các package cho JavaFX FXML reflection
	opens hust.soict.globalict.javafx to javafx.fxml;
}
