//
//  ImageView.swift
//  iosApp
//
//  Created by Andres Rivillas on 31/05/25.
//

import SwiftUI

struct ImageView: View {
    
    var imageUrl: String
    
    var body: some View {
        let defaultImage = Image(systemName: "basket")
            .resizable()
            .scaledToFit()
            .foregroundColor(Color(UIColor.systemGray))
        
        AsyncImage(url: URL(string: imageUrl)) { phase in
            switch phase {
            case .empty:
                ProgressView()
                    .frame(width: 80, height: 80)
            case .success(let image):
                image
                    .resizable()
                    .scaledToFill()
                    .overlay(
                        LinearGradient(
                            gradient: Gradient(colors: [
                                Color.black.opacity(0.6),
                                Color.black.opacity(0.0)
                            ]),
                            startPoint: .top,
                            endPoint: .bottom
                        )
                        .edgesIgnoringSafeArea(.top),
                        alignment: .top
                    )
            case .failure:
                defaultImage
                    .padding()
            @unknown default:
                defaultImage
            }
        }
    }
}
