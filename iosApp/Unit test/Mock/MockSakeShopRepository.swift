//
//  MockSakeShopRepository.swift
//  iosApp
//
//  Created by Andres Rivillas on 31/05/25.
//

import Shared

class MockSakeShopRepository: SakeShopRepository {
    
    var shopList: ResponseBase<NSMutableArray>?
    var serviceCalledTimes = 0
    
    func getShopList(completionHandler: @escaping (ResponseBase<NSMutableArray>?, (any Error)?) -> Void) {
        completionHandler(shopList, nil)
        serviceCalledTimes += 1
    }
}
