//
//  StarRatingView.swift
//  iosApp
//
//  Created by Andres Rivillas on 31/05/25.
//

import SwiftUI


struct StarRatingView: View {
    let rating: Double
    let maxRating = 5
    
    var body: some View {
        HStack(spacing: 2) {
            ForEach(0..<maxRating, id: \.self) { index in
                if Double(index) < rating {
                    if rating - Double(index) >= 1 {
                        Image(systemName: "star.fill")
                            .foregroundColor(.yellow)
                    } else {
                        Image(systemName: "star.leadinghalf.filled")
                            .foregroundColor(.yellow)
                    }
                } else {
                    Image(systemName: "star")
                        .foregroundColor(.gray)
                }
            }
            Text(String(format: "%.1f", rating))
                .font(.subheadline)
                .foregroundColor(.gray)
        }
    }
}
