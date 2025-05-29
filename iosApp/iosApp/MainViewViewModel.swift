//
//  MainViewViewModel.swift
//  iosApp
//
//  Created by Andres Rivillas on 29/05/25.
//

import Foundation
import Shared

class MainViewViewModel: ObservableObject {
    
    let repository = SakeShopModule.shared.createShopRepository()
    var response = [Shop]()
    
    func loadData() {
        repository.getShopList(){[weak self] result, error in
            guard let self = self else { return }
            response = result?.value as! [Shop]
            print("eo: \(response)")
        }
    }
}
