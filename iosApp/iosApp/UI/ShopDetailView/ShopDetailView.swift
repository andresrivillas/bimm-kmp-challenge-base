//
//  ShopDetailView.swift
//  iosApp
//
//  Created by Andres Rivillas on 31/05/25.
//

import SwiftUI

struct ShopDetailView: View {
    var shop: IdentifiableShop
    @Environment(\.dismiss) var dismiss
    @State private var showWebView = false
    
    var body: some View {
        VStack(spacing: 30) {
            ImageView(imageUrl: shop.shop.picture ?? "")
                .frame(height: 200)
                .clipShape(RoundedRectangle(cornerRadius: 10))
            
            Text(shop.shop.name ?? "")
                .font(.title)
            Text(shop.shop.address ?? "")
                .font(.subheadline)
                .foregroundColor(.secondary)
            StarRatingView(rating: shop.shop.rating as? Double ?? 0.0)
            Button {
                openURL(shop.shop.google_maps_link ?? "")
            } label: {
                HStack {
                    Image(systemName: "map.fill")
                        .foregroundColor(.blue)
                    Text(shop.shop.address ?? "")
                        .font(.caption)
                        .foregroundColor(.primary)
                }
            }
            
            Button {
                showWebView = true
            } label: {
                Text("Visit Website")
                    .font(.headline)
                    .frame(maxWidth: .infinity)
                    .padding()
                    .background(Color.blue)
                    .foregroundColor(.white)
                    .cornerRadius(14)
            }
            .padding(.horizontal, 24)
            .sheet(isPresented: $showWebView) {
                if let url = URL(string: shop.shop.website ?? "") {
                    SafariView(url: url)
                }
            }
            Spacer()
            
        }
        .cornerRadius(10)
    }
}
