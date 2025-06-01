//
//  File.swift
//  iosApp
//
//  Created by Andres Rivillas on 31/05/25.
//

import SwiftUI

func openURL(_ urlString: String) {
    guard let url = URL(string: urlString),
          UIApplication.shared.canOpenURL(url) else {
        print("Invalid URL")
        return
    }
    
    UIApplication.shared.open(url, options: [:], completionHandler: nil)
}
