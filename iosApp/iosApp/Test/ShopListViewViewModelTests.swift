import XCTest
@testable import YourModuleName

final class ShopListViewViewModelTests: XCTestCase {
    
    func testLoadData_ShouldUpdateShops() {
        // Given
        let mockRepository = MockSakeShopRepository()
        let expectedShops = [Shop(id: 1, name: "Sake Heaven"), Shop(id: 2, name: "Rice Dreams")]
        mockRepository.shopList = expectedShops
        let viewModel = ShopListViewViewModel(repository: mockRepository)

        // When
        let expectation = XCTestExpectation(description: "Shops should be loaded")
        let cancellable = viewModel.$shops
            .dropFirst() // initial value
            .sink { shops in
                XCTAssertEqual(shops.count, expectedShops.count)
                XCTAssertEqual(shops.map(\.name), expectedShops.map(\.name))
                expectation.fulfill()
            }
        
        viewModel.loadData()

        // Then
        wait(for: [expectation], timeout: 1.0)
        cancellable.cancel()
    }
}